package com.code.vv.model;

import java.util.Date;

/**
 * Created on 2020/8/27.
 * 车辆违章信息表
 * com.code.vv.model
 *
 * @author Zjianru
 */
public class ViolationInfoTb {
    /**
     * 违章信息 ID
     */
    private Integer id;

    /**
     * 车辆车牌，逻辑对应 violation_car_tb 中
     * license_plate 字段的值
     */
    private String licensePlate;

    /**
     * 违章时间
     */
    private Date time;

    /**
     * 车辆违章地点
     */
    private String place;

    /**
     * 违章内容  对应 violation_context_tb 表中的 ID
     */
    private Integer violationContext;

    /**
     * 违章司机驾照信息  若不扣分 此字段可为空
     */
    private String driverLicense;
    /**
     * 扣分状态：1：扣分 0：不扣分
     */
    private Integer deductionStatus;

    /**
     * 缴费状态：1：需缴费 0：不缴费
     */
    private Integer amerceStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate == null ? null : licensePlate.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getViolationContext() {
        return violationContext;
    }

    public void setViolationContext(Integer violationContext) {
        this.violationContext = violationContext;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense == null ? null : driverLicense.trim();
    }

    public Integer getDeductionStatus() {
        return deductionStatus;
    }

    public void setDeductionStatus(Integer deductionStatus) {
        this.deductionStatus = deductionStatus;
    }

    public Integer getAmerceStatus() {
        return amerceStatus;
    }

    public void setAmerceStatus(Integer amerceStatus) {
        this.amerceStatus = amerceStatus;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", licensePlate=" + licensePlate +
                ", time=" + time +
                ", place=" + place +
                ", violationContext=" + violationContext +
                ", driverLicense=" + driverLicense +
                ", deductionStatus=" + deductionStatus +
                ", amerceStatus=" + amerceStatus +
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
        ViolationInfoTb other = (ViolationInfoTb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getLicensePlate() == null ? other.getLicensePlate() == null : this.getLicensePlate().equals(other.getLicensePlate()))
                && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
                && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
                && (this.getViolationContext() == null ? other.getViolationContext() == null : this.getViolationContext().equals(other.getViolationContext()))
                && (this.getDriverLicense() == null ? other.getDriverLicense() == null : this.getDriverLicense().equals(other.getDriverLicense()))
                && (this.getDeductionStatus() == null ? other.getDeductionStatus() == null : this.getDeductionStatus().equals(other.getDeductionStatus()))
                && (this.getAmerceStatus() == null ? other.getAmerceStatus() == null : this.getAmerceStatus().equals(other.getAmerceStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLicensePlate() == null) ? 0 : getLicensePlate().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getViolationContext() == null) ? 0 : getViolationContext().hashCode());
        result = prime * result + ((getDriverLicense() == null) ? 0 : getDriverLicense().hashCode());
        result = prime * result + ((getDeductionStatus() == null) ? 0 : getDeductionStatus().hashCode());
        result = prime * result + ((getAmerceStatus() == null) ? 0 : getAmerceStatus().hashCode());
        return result;
    }
}