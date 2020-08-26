package com.code.vv.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.code.vv.mapper.ViolationCarTbMapper;
import com.code.vv.model.ViolationCarTb;
import com.code.vv.service.ViolationCarTbService;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

@Service
public class ViolationCarTbServiceImpl implements ViolationCarTbService {

    @Resource
    private ViolationCarTbMapper violationCarTbMapper;

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return delete count
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return violationCarTbMapper.deleteByPrimaryKey(id);
    }
    /**
     * 插入（新增）
     * @param record 新增对象
     * @return insert count
     */
    @Override
    public int insert(ViolationCarTb record) {
        return violationCarTbMapper.insert(record);
    }
    /**
     * 选择性插入 （某属性为空）
     * @param record 插入对象
     * @return insert count
     */
    @Override
    public int insertSelective(ViolationCarTb record) {
        return violationCarTbMapper.insertSelective(record);
    }
    /**
     * 根据主键查找
     * @param id 主键
     * @return ViolationCarTb 封装好的对象
     */
    @Override
    public ViolationCarTb selectByPrimaryKey(Integer id) {
        return violationCarTbMapper.selectByPrimaryKey(id);
    }
    /**
     * 根据主键选择性更新
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKeySelective(ViolationCarTb record) {
        return violationCarTbMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 根据主键更新
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKey(ViolationCarTb record) {
        return violationCarTbMapper.updateByPrimaryKey(record);
    }
    /**
     * 批量选择性更新
     * @param list batch list
     * @return update count
     */
    @Override
    public int updateBatchSelective(List<ViolationCarTb> list) {
        return violationCarTbMapper.updateBatchSelective(list);
    }

    @Override
    public List<ViolationCarTb> findAll() {
        return violationCarTbMapper.findAll();
    }

    @Override
    public List<ViolationCarTb> selectByLicensePlate(String licensePlate) {
        return violationCarTbMapper.selectByLicensePlate(licensePlate);
    }
}
