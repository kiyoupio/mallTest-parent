package com.yangpai.commodity.server.enums;

/**
 * 商品审核状态枚举类
 * @author kuangyoupeng
 * @date 2022.3.6
 */
public enum AuditStatusEnum {
    /**
     * 管理员操作无需审核
     */
    NO_AUDIT(0, "管理员操作"),

    /**
     * 等待审核
     */
    WAIT_AUDIT(1, "待审核"),

    /**
     * 审核中
     */
    AUDIT_ING(2, "审核中"),

    /**
     * 审核通过
     */
    AUDIT_PASS(3, "审核通过"),

    /**
     * 审核不通过
     */
    AUDIT_NOT_PASS(4, "审核不通过");

    /**
     * 商品审核状态
     */
    private final int auditStatus;

    /**
     * 状态描述
     */
    private final String desc;

    /**
     * 构造enum
     * @param auditStatus
     * @param desc
     */
    AuditStatusEnum(int auditStatus, String desc){
        this.auditStatus = auditStatus;
        this.desc = desc;
    }
}
