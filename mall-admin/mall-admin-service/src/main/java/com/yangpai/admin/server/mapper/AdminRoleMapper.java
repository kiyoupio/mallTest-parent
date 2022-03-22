package com.yangpai.admin.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpai.admin.core.entity.AdminRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色mapper接口
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    /**
     * 根据用户id获取角色列表
     * @param id
     * @return
     */
    List<AdminRole> getRolesByUserId(Long id);
}
