package com.yangpai.admin.core.api;

import com.yangpai.admin.core.entity.AdminRole;
import com.yangpai.admin.core.entity.AdminUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 用户远程API
 *
 * @author kuangyoupeng1
 * @date 2022.1.25
 */
@RequestMapping(value = "/user")
public interface UserApi {

    /**
     * 根据用户名称获取详细用户信息
     *
     * @param userName 用户名称
     * @return 用户详细信息
     */
    @GetMapping("/get/{userName}")
    AdminUser getByUserName(@PathVariable("userName") String userName);

    /**
     * 根据用户id获取角色列表
     *
     * @param id 用户id
     * @return 角色列表
     */
    @GetMapping("/select-roles/{id}")
    List<AdminRole> getRolesByUserId(@PathVariable("id") Long id);

    /**
     * 添加端点
     *
     * @param point    端点
     * @param username 用户名
     */
    @GetMapping(value = "/add-point")
    void addPoint(@RequestParam("point") Long point, @RequestParam("username") String username);

}
