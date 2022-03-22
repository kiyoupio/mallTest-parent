package com.yangpai.admin.server.controller;

import com.yangpai.admin.core.dto.CreateRequestDTO;
import com.yangpai.admin.core.entity.AdminRole;
import com.yangpai.admin.core.entity.AdminUser;
import com.yangpai.admin.server.constant.AdminConstants;
import com.yangpai.admin.server.service.AdminUserService;
import com.yangpai.admin.server.service.impl.EmailService;
import com.yangpai.admin.server.service.impl.RedisService;
import com.yangpai.conmon.component.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 用户控制器类
 * @author kuangyoupeng1
 * @date 2022.1.26
 */
@RestController
@Slf4j
public class AdminUserController {

    /**
     * 用户服务类
     */
    @Resource
    private AdminUserService adminUserService;

    /**
     * redis服务
     */
    @Resource
    private RedisService redisService;

    /**
     * 邮箱服务
     */
    @Resource
    private EmailService emailService;

    /**
     * 加密工具
     */
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 根据用户名获取用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    @GetMapping("user/get/{userName}")
    public AdminUser getByUserName(@PathVariable("userName")String userName){
        log.debug("用户{}获取信息", userName);
        return adminUserService.getAdminUserByUserName(userName);
    }

    /**
     * 根据用户id获取用户权限
     * @param id
     * @return
     */
    @GetMapping("user/select-roles/{id}")
    public List<AdminRole> getRolesByUserId(@PathVariable("id") Long id) {
        return adminUserService.getRolesByUserId(id);
    }

    /**
     * 注册时获取邮箱验证码
     * @param email
     * @return
     */
    @GetMapping("/user/register/code")
    public ApiResult getEmailCodeForRegister(@RequestParam String email){
        if (StringUtils.isBlank(email)){
            return ApiResult.error("邮箱不能为空");
        }
        if (adminUserService.isExistEmail(email)){
            return ApiResult.error("邮箱已经被注册");
        }
        // 发送一个随机6位数验证码
        String code = String.valueOf(new Random().nextInt(899999) + 100000);
        String key = StringUtils.join(Arrays.asList(AdminConstants.REGISTER_CODE_PREFIX, email), AdminConstants.SPLIT);
        redisService.setCacheObject(key, code, 15, TimeUnit.MINUTES);
        try {
            emailService.sendMail(email, code);
        }catch (Exception e){
            log.error("邮件发送出错:{}", e.getClass().getSimpleName());
            return ApiResult.error("邮件发送失败,请重试");
        }
        return ApiResult.success();
    }

    /**
     * 重置时获取邮箱验证码
     * @param email
     * @return
     */
    @GetMapping("/user/reset/code")
    public ApiResult getEmailCodeForReset(@RequestParam String email){
        if (StringUtils.isBlank(email)){
            return ApiResult.error("邮箱不能为空");
        }
        if (!adminUserService.isExistEmail(email)){
            return ApiResult.error("邮箱未被注册");
        }
        // 发送一个随机6位数验证码
        String code = String.valueOf(new Random().nextInt(899999) + 100000);
        String key = StringUtils.join(Arrays.asList(AdminConstants.RESET_CODE_PREFIX, email), AdminConstants.SPLIT);
        redisService.setCacheObject(key, code, 15, TimeUnit.MINUTES);
        try {
            emailService.sendMail(email, code);
        }catch (Exception e){
            log.error("邮件发送出错:{}", e.getClass().getSimpleName());
            return ApiResult.error("邮件发送失败,请重试");
        }
        return ApiResult.success();
    }

    /**
     * 新增用户
     * @param createRequestDTO
     * @return
     */
    @PostMapping("user/save")
    public ApiResult createUser(@RequestBody CreateRequestDTO createRequestDTO){
        String key = StringUtils.join(Arrays.asList(AdminConstants.REGISTER_CODE_PREFIX, createRequestDTO.getEmail()), AdminConstants.SPLIT);
        String redisCode = redisService.getCacheObject(key);
        if (StringUtils.isBlank(createRequestDTO.getCode())
                || StringUtils.isBlank(redisCode)
                || !createRequestDTO.getCode().equals(redisCode)){
            return ApiResult.error("验证码错误");
        }
        if (adminUserService.isExistUsername(createRequestDTO.getUserName())){
            return ApiResult.error("用户名已被注册");
        }
        adminUserService.insertAdminUser(createRequestDTO);
        return ApiResult.success();
    }

    /**
     * 重置密码阶段一：check code
     * @param email
     * @param code
     * @return
     */
    @GetMapping("user/reset/check/code")
    public ApiResult resetCheckCode(@RequestParam String email, @RequestParam String code){
        // check code
        String key = StringUtils.join(Arrays.asList(AdminConstants.RESET_CODE_PREFIX, email), AdminConstants.SPLIT);
        String redisCode = redisService.getCacheObject(key);
        if (StringUtils.isBlank(code)
                || StringUtils.isBlank(redisCode)
                || !code.equals(redisCode)){
            return ApiResult.error("验证码错误");
        }
        // 验证通过返回提交时间
        long submitTime = System.currentTimeMillis();
        // 根据验证码和提交时间再维护一个缓存，用于连贯重置密码前后操作
        redisService.setCacheObject(code + ":" + submitTime, email, 15, TimeUnit.MINUTES);
        return ApiResult.success(submitTime);
    }

    /**
     * 重置密码阶段二：reset password
     * @param code
     * @param submitTime
     * @param password
     * @return
     */
    @GetMapping("user/reset/password")
    public ApiResult resetPassword(@RequestParam String code, @RequestParam long submitTime, @RequestParam String password){
        String email = redisService.getCacheObject(code + ":" + submitTime);
        if (StringUtils.isBlank(email)){
            return ApiResult.error("请重新验证邮箱");
        }
        adminUserService.resetPasswordByEmail(email, password);
        return ApiResult.success("密码重置成功");
    }
}
