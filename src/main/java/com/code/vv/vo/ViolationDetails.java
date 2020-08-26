package com.code.vv.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 2020/8/24.
 * com.code.vv.vo
 *
 * @author Zjianru
 */
public class ViolationDetails {
    /**
     * 违章信息 ID
     */
    private Integer violationId;

    /**
     * 车辆车牌，逻辑对应 violation_car_tb 中license_plate 字段的值
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
     * 违章司机驾照信息  若不扣分 此字段可为空
     */
    private String driverLicense;

    /**
     * 违章内容  对应 violation_context_tb 表中的 ID
     */
    private Integer violationContextId;


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



    public ViolationDetails(Integer violationId, String licensePlate, Date time, String place,
                            Integer violationContextId, String context, Integer deduction, BigDecimal amerce,
                            String driverLicense) {
        this.violationId = violationId;
        this.licensePlate = licensePlate;
        this.time = time;
        this.place = place;
        this.violationContextId = violationContextId;
        this.context = context;
        this.deduction = deduction;
        this.amerce = amerce;
        this.driverLicense = driverLicense;
    }

    public ViolationDetails() {

    }

    public BigDecimal getAmerce() {
        return amerce;
    }

    public void setAmerce(BigDecimal amerce) {
        this.amerce = amerce;
    }

    public Integer getViolationId() {
        return violationId;
    }

    public void setViolationId(Integer violationId) {
        this.violationId = violationId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
        this.place = place;
    }

    public Integer getViolationContextId() {
        return violationContextId;
    }

    public void setViolationContextId(Integer violationContextId) {
        this.violationContextId = violationContextId;
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

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }
}
