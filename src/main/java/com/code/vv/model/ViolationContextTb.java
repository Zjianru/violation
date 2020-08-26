package com.code.vv.model;

import java.math.BigDecimal;

/**
 * Created on 2020/8/26.
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
    private BigDecimal amerce;

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
        this.context = context;
    }

    public Integer getDeduction() {
        return deduction;
    }

    public void setDeduction(Integer deduction) {
        this.deduction = deduction;
    }

    public BigDecimal getAmerce() {
        return amerce;
    }

    public void setAmerce(BigDecimal amerce) {
        this.amerce = amerce;
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
                && (this.getAmerce() == null ? other.getAmerce() == null : this.getAmerce().equals(other.getAmerce()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getDeduction() == null) ? 0 : getDeduction().hashCode());
        result = prime * result + ((getAmerce() == null) ? 0 : getAmerce().hashCode());
        return result;
    }
}