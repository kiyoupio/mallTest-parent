package com.yangpai.admin.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpai.admin.core.entity.AdminRoleUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色mapper接口
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Mapper
public interface AdminRoleUserMapper extends BaseMapper<AdminRoleUser> {
}
