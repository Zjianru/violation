package com.code.vv.mapper;
import org.apache.ibatis.annotations.Param;

import com.code.vv.model.ViolationCarTb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/8/24.
 * com.code.vv.mapper
 *
 * @author Zjianru
 */
@Mapper
public interface ViolationCarTbMapper {
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
    int insert(ViolationCarTb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ViolationCarTb record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ViolationCarTb selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationCarTb record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ViolationCarTb record);

    /**
     * update Batch Selective
     *
     * @param list Batch list
     * @return update count
     */
    int updateBatchSelective(List<ViolationCarTb> list);

    /**
     * 查询所有车辆信息
     * @return List<ViolationCarTb>
     */
    List<ViolationCarTb> findAll();


}