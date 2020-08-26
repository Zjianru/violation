package com.code.vv.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.code.vv.model.ViolationContextTb;

/**
 * Created on 2020/8/26.
 * com.code.vv.mapper
 *
 * @author Zjianru
 */
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
     * findAll Context
     * @return ist<ViolationContextTb>
     */
    List<ViolationContextTb> findAll();

    /**
     * findByContext
     * @param context 违章内容
     * @return 查找是否有违章内容存在
     */
    List<ViolationContextTb> findByContext(@Param("context")String context);


}