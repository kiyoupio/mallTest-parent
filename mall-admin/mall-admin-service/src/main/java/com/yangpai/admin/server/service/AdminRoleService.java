package com.yangpai.admin.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpai.admin.core.entity.AdminRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务接口
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Service
public interface AdminRoleService extends IService<AdminRole> {
    /**
     * 根据用户id获取角色列表
     * @param id
     * @return
     */
    List<AdminRole> getRolesByUserId(Long id);
}
