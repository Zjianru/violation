package com.code.vv.model;

import java.math.BigDecimal;

/**
 * Created on 2020/8/24.
 * com.code.vv.model
 * 违章内容表，逻辑上被包含在违章信息表 violation_info_tb 表下
 * @author Zjianru
 */
public class ViolationContextTb {
    /**
     * 违章内容 ID
     */
    private Integer id;

    /**
     * 违章内容，实际指违章项目  eg:闯红灯
     */
    private String context;

    /**
     * 扣分情况，为 0 为不扣分
     */
    private Integer deduction;

    /**
     * 罚款情况 为 0 则为不罚款
     */
    private Long amerce;

    /**
     * 违章司机驾照信息  若不扣分 此字段可为空
     */
    private String driverLicense;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getDeduction() {
        return deduction;
    }

    public void setDeduction(Integer deduction) {
        this.deduction = deduction;
    }

    public Long getAmerce() {
        return amerce;
    }

    public void setAmerce(Long amerce) {
        this.amerce = amerce;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense == null ? null : driverLicense.trim();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", context=" + context +
                ", deduction=" + deduction +
                ", amerce=" + amerce +
                ", driverLicense=" + driverLicense +
                "]";
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ViolationContextTb other = (ViolationContextTb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
                && (this.getDeduction() == null ? other.getDeduction() == null : this.getDeduction().equals(other.getDeduction()))
                && (this.getAmerce() == null ? other.getAmerce() == null : this.getAmerce().equals(other.getAmerce()))
                && (this.getDriverLicense() == null ? other.getDriverLicense() == null : this.getDriverLicense().equals(other.getDriverLicense()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getDeduction() == null) ? 0 : getDeduction().hashCode());
        result = prime * result + ((getAmerce() == null) ? 0 : getAmerce().hashCode());
        result = prime * result + ((getDriverLicense() == null) ? 0 : getDriverLicense().hashCode());
        return result;
    }
}