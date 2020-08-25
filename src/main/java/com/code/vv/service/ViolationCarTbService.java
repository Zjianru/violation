package com.code.vv.service;

import java.util.List;

import com.code.vv.model.ViolationCarTb;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

public interface ViolationCarTbService {

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return delete count
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入（新增）
     * @param record 新增对象
     * @return insert count
     */
    int insert(ViolationCarTb record);

    /**
     * 选择性插入 （某属性为空）
     * @param record 插入对象
     * @return insert count
     */
    int insertSelective(ViolationCarTb record);

    /**
     * 根据主键查找
     * @param id 主键
     * @return ViolationCarTb 封装好的对象
     */
    ViolationCarTb selectByPrimaryKey(Integer id);

    /**
     * 根据主键选择性更新
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationCarTb record);

    /**
     * 根据主键更新
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKey(ViolationCarTb record);

    /**
     * 批量选择性更新
     * @param list batch list
     * @return update count
     */
    int updateBatchSelective(List<ViolationCarTb> list);

    /**
     * 查询所有车辆信息
     * @return List<ViolationCarTb>
     */
    List<ViolationCarTb> findAll();
}
