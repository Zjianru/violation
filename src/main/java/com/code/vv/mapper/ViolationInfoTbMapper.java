package com.code.vv.mapper;

import com.code.vv.model.ViolationInfoTb;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created on 2020/8/27.
 * com.code.vv.mapper
 *
 * @author Zjianru
 */

public interface ViolationInfoTbMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(ViolationInfoTb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ViolationInfoTb record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ViolationInfoTb selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationInfoTb record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ViolationInfoTb record);

    /**
     * findAll
     *
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findAll();

    /**
     * 根据驾驶证信息查找所有
     *
     * @param driverLicense 驾驶证
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findByDriverLicense(@Param("driverLicense") String driverLicense);

    /**
     * 在某段时间范围内某驾驶证的违章信息
     * @param minTime 从什么时间开始算起
     * @param maxTime 当前时间
     * @param driverLicense 驾驶证信息
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findAllByTimeBetweenAndDriverLicense(@Param("minTime") Date minTime, @Param("maxTime") Date maxTime, @Param("driverLicense") String driverLicense);

    /**
     * 根据车牌找所有
     * @param licensePlate licensePlate
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findAllByLicensePlate(@Param("licensePlate")String licensePlate);

    /**
     * 找不同状态的信息
     * @param licensePlate licensePlate
     * @param amerceStatus amerceStatus
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findAllByLicensePlateAndAmerceStatus(@Param("licensePlate")String licensePlate,@Param("amerceStatus")Integer amerceStatus);

}