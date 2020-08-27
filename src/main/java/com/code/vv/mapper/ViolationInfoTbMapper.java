package com.code.vv.mapper;

import com.code.vv.model.ViolationInfoTb;
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
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findAll();
}