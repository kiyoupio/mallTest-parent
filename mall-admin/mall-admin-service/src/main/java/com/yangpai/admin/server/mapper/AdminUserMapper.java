package com.yangpai.admin.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpai.admin.core.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper接口
 * @author kuangyoupeng1
 * @date 2022.1.24
 */
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    AdminUser selectAdminUserById(Long id);
}