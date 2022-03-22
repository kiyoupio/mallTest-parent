package com.yangpai.admin.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpai.admin.core.entity.AdminRoleUser;
import com.yangpai.admin.server.mapper.AdminRoleUserMapper;
import com.yangpai.admin.server.service.AdminRoleUserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Service
public class AdminRoleUserServiceImpl extends ServiceImpl<AdminRoleUserMapper, AdminRoleUser> implements AdminRoleUserService {
}
