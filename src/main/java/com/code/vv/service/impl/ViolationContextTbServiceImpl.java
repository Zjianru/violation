package com.code.vv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.code.vv.mapper.ViolationContextTbMapper;

import java.util.List;

import com.code.vv.model.ViolationContextTb;
import com.code.vv.service.ViolationContextTbService;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

@Service
public class ViolationContextTbServiceImpl implements ViolationContextTbService {

    @Autowired
    private ViolationContextTbMapper violationContextTbMapper;

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return delete count
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return violationContextTbMapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入（新增）
     *
     * @param record 新增对象
     * @return insert count
     */
    @Override
    public int insert(ViolationContextTb record) {
        return violationContextTbMapper.insert(record);
    }

    /**
     * 选择性插入 （某属性为空）
     *
     * @param record 插入对象
     * @return insert count
     */
    @Override
    public int insertSelective(ViolationContextTb record) {
        return violationContextTbMapper.insertSelective(record);
    }

    /**
     * 根据主键查找
     *
     * @param id 主键
     * @return ViolationContextTb 封装好的对象
     */
    @Override
    public ViolationContextTb selectByPrimaryKey(Integer id) {
        return violationContextTbMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键选择性更新
     *
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKeySelective(ViolationContextTb record) {
        return violationContextTbMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键更新
     *
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKey(ViolationContextTb record) {
        return violationContextTbMapper.updateByPrimaryKey(record);
    }



}
