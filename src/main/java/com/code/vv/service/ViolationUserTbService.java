package com.code.vv.service;

import com.code.vv.model.ViolationUserTb;

import java.util.List;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

public interface ViolationUserTbService {

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
    int insert(ViolationUserTb record);

    /**
     * 选择性插入 （某属性为空）
     *
     * @param record 插入对象
     * @return insert count
     */
    int insertSelective(ViolationUserTb record);

    /**
     * 根据主键查找
     *
     * @param id 主键
     * @return ViolationUserTb 封装好的对象
     */
    ViolationUserTb selectByPrimaryKey(Integer id);

    /**
     * 根据主键选择性更新
     *
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationUserTb record);

    /**
     * 根据主键更新
     *
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKey(ViolationUserTb record);

    /**
     * 批量选择性更新
     *
     * @param list batch list
     * @return update count
     */
    int updateBatchSelective(List<ViolationUserTb> list);

    /**
     * 登陆用
     * @param name 用户名
     * @param password 密码
     * @return 查到的用户对象
     */
    ViolationUserTb login(String name,String password);

    /**
     * 查找所有用户信息
     * @return List<ViolationUserTb>
     */
    List<ViolationUserTb> findAll();

}
