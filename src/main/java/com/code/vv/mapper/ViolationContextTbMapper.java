package com.code.vv.mapper;

import com.code.vv.model.ViolationContextTb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2020/8/24.
 * com.code.vv.mapper
 *
 * @author Zjianru
 */
@Mapper
public interface ViolationContextTbMapper {
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
    int insert(ViolationContextTb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ViolationContextTb record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ViolationContextTb selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationContextTb record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ViolationContextTb record);

    /**
     * update Batch Selective
     *
     * @param list Batch list
     * @return update count
     */
    int updateBatchSelective(List<ViolationContextTb> list);
}