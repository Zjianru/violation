package com.code.vv.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.code.vv.model.ViolationUserTb;

import java.util.List;

import com.code.vv.mapper.ViolationUserTbMapper;
import com.code.vv.service.ViolationUserTbService;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

@Service
public class ViolationUserTbServiceImpl implements ViolationUserTbService {

    @Resource
    private ViolationUserTbMapper violationUserTbMapper;

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return delete count
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return violationUserTbMapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入（新增）
     *
     * @param record 新增对象
     * @return insert count
     */
    @Override
    public int insert(ViolationUserTb record) {
        return violationUserTbMapper.insert(record);
    }

    /**
     * 选择性插入 （某属性为空）
     *
     * @param record 插入对象
     * @return insert count
     */
    @Override
    public int insertSelective(ViolationUserTb record) {
        return violationUserTbMapper.insertSelective(record);
    }

    /**
     * 根据主键查找
     *
     * @param id 主键
     * @return ViolationUserTb 封装好的对象
     */
    @Override
    public ViolationUserTb selectByPrimaryKey(Integer id) {
        return violationUserTbMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键选择性更新
     *
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKeySelective(ViolationUserTb record) {
        return violationUserTbMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键更新
     *
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKey(ViolationUserTb record) {
        return violationUserTbMapper.updateByPrimaryKey(record);
    }

    /**
     * 批量选择性更新
     *
     * @param list batch list
     * @return update count
     */
    @Override
    public int updateBatchSelective(List<ViolationUserTb> list) {
        return violationUserTbMapper.updateBatchSelective(list);
    }

    /**
     * 登陆用
     * @param userName 用户名
     * @param password 密码
     * @return 查到的用户对象
     */
    @Override
    public ViolationUserTb login(String userName, String password) {
        return violationUserTbMapper.login(userName,password);
    }
}
