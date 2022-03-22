package com.yangpai.conmon.baseclass;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 * @author kuangyoupeng1
 * @date 2022.1.21
 */
@Setter
@Getter
@ToString
public class BaseEntity implements Serializable {
    /**
     * 实体编号（唯一标识）
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 分页信息:页
     */
    @TableField(exist = false)
    private Integer pageNum;

    /**
     * 分页信息:每页数量
     */
    @TableField(exist = false)
    private Integer pageSize;
}