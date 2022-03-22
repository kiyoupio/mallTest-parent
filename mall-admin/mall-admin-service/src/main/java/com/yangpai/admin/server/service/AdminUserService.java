package com.yangpai.admin.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpai.admin.core.dto.CreateRequestDTO;
import com.yangpai.admin.core.entity.AdminRole;
import com.yangpai.admin.core.entity.AdminUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务接口
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
@Service
public interface AdminUserService extends IService<AdminUser> {
    /**
     * 根据用户名称获取详细用户信息
     *
     * @param userName 用户名称
     * @return 用户详细信息
     */
    AdminUser getAdminUserByUserName(String userName);

    /**
     * 根据用户id获取角色列表
     *
     * @param id
     * @return
     */
    List<AdminRole> getRolesByUserId(Long id);

    /**
     * 新建用户
     *
     * @param createRequestDTO
     */
    void insertAdminUser(CreateRequestDTO createRequestDTO);

    /**
     * 是否存在邮箱
     *
     * @param email
     * @return
     */
    boolean isExistEmail(String email);

    /**
     * 是否存在用户名
     *
     * @param username
     * @return
     */
    boolean isExistUsername(String username);

    /**
     * 根据邮箱修改密码
     *
     * @param email
     * @param password
     */
    void resetPasswordByEmail(String email, String password);
}
