package com.code.vv.mapper;

import com.code.vv.model.ViolationUserTb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2020/8/24.
 * com.code.vv.mapper
 *
 * @author Zjianru
 */
@Mapper
public interface ViolationUserTbMapper {
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
    int insert(ViolationUserTb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ViolationUserTb record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ViolationUserTb selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationUserTb record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ViolationUserTb record);

    /**
     * update Batch Selective
     *
     * @param list Batch list
     * @return update count
     */
    int updateBatchSelective(List<ViolationUserTb> list);

    /**
     * 登陆用
     * @param name 用户名
     * @param password 密码
     * @return 查到的对象
     */
    ViolationUserTb login(@Param("name")String name, @Param("password")String password);

    /**
     * 查找所有用户信息
     * @return List<ViolationUserTb>
     */
    List<ViolationUserTb> findAll();


}