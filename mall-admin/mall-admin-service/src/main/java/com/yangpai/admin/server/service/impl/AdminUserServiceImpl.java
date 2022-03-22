package com.yangpai.admin.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.admin.core.dto.CreateRequestDTO;
import com.yangpai.admin.core.entity.AdminRole;
import com.yangpai.admin.core.entity.AdminRoleUser;
import com.yangpai.admin.core.entity.AdminUser;
import com.yangpai.admin.server.mapper.AdminUserMapper;
import com.yangpai.admin.server.service.AdminRoleService;
import com.yangpai.admin.server.service.AdminRoleUserService;
import com.yangpai.admin.server.service.AdminUserService;
import com.yangpai.admin.server.utils.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
@Service
@Slf4j
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Resource
    private AdminRoleService adminRoleService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AdminRoleUserService adminRoleUserService;

    @Override
    public AdminUser getAdminUserByUserName(String userName) {
        return this.getOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getUserName, userName));
    }

    @Override
    public List<AdminRole> getRolesByUserId(Long id) {
        return adminRoleService.getRolesByUserId(id);
    }

    @Override
    public void insertAdminUser(CreateRequestDTO createRequestDTO) {
        // 转换AdminUser
        AdminUser adminUser = new AdminUser();
        adminUser.setUserName(createRequestDTO.getUserName());
        adminUser.setEmail(createRequestDTO.getEmail());
        adminUser.setPassword(passwordEncoder.encode(createRequestDTO.getPassword()));
        adminUser.setSchool(createRequestDTO.getSchool());
        adminUser.setTel(createRequestDTO.getTel());
        this.save(adminUser);
        // 默认注册只给User权限:2L
        AdminRoleUser adminRoleUser = new AdminRoleUser();
        adminRoleUser.setRoleId(2L);
        adminRoleUser.setUserId(adminUser.getId());
        adminRoleUserService.save(adminRoleUser);
    }

    @Override
    public boolean isExistEmail(String email) {
        AdminUser adminUser = this.getOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getEmail, email));
        return adminUser != null;
    }

    @Override
    public boolean isExistUsername(String username) {
        AdminUser adminUser = this.getOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getUserName, username));
        return adminUser != null;
    }

    @Override
    public void resetPasswordByEmail(String email, String password) {
        this.update(new LambdaUpdateWrapper<AdminUser>().eq(AdminUser::getEmail, email)
                .set(AdminUser::getPassword, passwordEncoder.encode(password)));
    }
}