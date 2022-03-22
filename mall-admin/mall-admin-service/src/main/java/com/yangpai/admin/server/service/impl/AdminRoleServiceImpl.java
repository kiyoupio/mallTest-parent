package com.yangpai.admin.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.admin.core.entity.AdminRole;
import com.yangpai.admin.server.mapper.AdminRoleMapper;
import com.yangpai.admin.server.service.AdminRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务实现类
 *
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {


    @Override
    public List<AdminRole> getRolesByUserId(Long id) {
        return baseMapper.getRolesByUserId(id);
    }
}
