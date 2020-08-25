package com.code.vv.model;

/**
 * Created on 2020/8/24.
 * com.code.vv.model
 * 车辆信息表
 *
 * @author Zjianru
 */
public class ViolationCarTb {
    /**
     * 车辆注册 ID
     */
    private Integer id;

    /**
     * 车辆车牌信息
     */
    private String licensePlate;

    /**
     * 车辆颜色
     */
    private String color;

    /**
     * 车辆限乘人数
     */
    private Integer seatNumber;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", licensePlate=" + licensePlate +
                ", color=" + color +
                ", seatNumber=" + seatNumber +
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
        ViolationCarTb other = (ViolationCarTb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getLicensePlate() == null ? other.getLicensePlate() == null : this.getLicensePlate().equals(other.getLicensePlate()))
                && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
                && (this.getSeatNumber() == null ? other.getSeatNumber() == null : this.getSeatNumber().equals(other.getSeatNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLicensePlate() == null) ? 0 : getLicensePlate().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getSeatNumber() == null) ? 0 : getSeatNumber().hashCode());
        return result;
    }
}