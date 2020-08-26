package com.code.vv.service;

import java.util.List;

import com.code.vv.model.ViolationContextTb;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

public interface ViolationContextTbService {

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return delete count
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入（新增）
     *
     * @param record 新增对象
     * @return insert count
     */
    int insert(ViolationContextTb record);

    /**
     * 选择性插入 （某属性为空）
     *
     * @param record 插入对象
     * @return insert count
     */
    int insertSelective(ViolationContextTb record);

    /**
     * 根据主键查找
     *
     * @param id 主键
     * @return ViolationContextTb 封装好的对象
     */
    ViolationContextTb selectByPrimaryKey(Integer id);

    /**
     * 根据主键选择性更新
     *
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationContextTb record);

    /**
     * 根据主键更新
     *
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKey(ViolationContextTb record);

}
