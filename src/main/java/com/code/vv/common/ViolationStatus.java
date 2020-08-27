package com.code.vv.common;

/**
 * Created on 2020/8/27.
 * com.code.vv.common
 * 扣分状态 deductionStatus ：1：扣分 0：不扣分
 * 缴费状态 amerceStatus ：1：需缴费 0：不缴费
 * 合起来就是惩罚状态
 * 扣分不缴费 -- 进驾驶证输入页面 --> (1,0)
 * 不缴费不扣分（最终状态） --> (0,0)
 * 缴费并扣分 -- 进驾驶证输入页面 --> (1,1)
 * 缴费不扣分 --> (0,1)
 * 添加违章信息时，选择性加入状态
 * 修改时查到，并做出修改，改动组合状态
 * @author Zjianru
 */

public enum ViolationStatus {
    /**
     * 扣分并需要缴费
     */
    deductionAndAmerce(1,1),
    /**
     * 缴费但不扣分
     */
    Amerce(1,0),
    /**
     * 扣分不缴费
     */
    Deduction(0,1),
    /**
     * 不扣分不缴费
     */
    finish(0,0);

    ViolationStatus(int deductionStatus, int amerceStatus) {
        this.deductionStatus = deductionStatus;
        this.amerceStatus = amerceStatus;
    }

    private final int deductionStatus;
    private final int amerceStatus;

    public int getDeductionStatus() {
        return deductionStatus;
    }

    public int getAmerceStatus() {
        return amerceStatus;
    }

}
