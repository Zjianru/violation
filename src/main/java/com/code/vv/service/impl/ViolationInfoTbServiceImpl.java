package com.code.vv.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.code.vv.mapper.ViolationInfoTbMapper;
import com.code.vv.model.ViolationInfoTb;
import com.code.vv.service.ViolationInfoTbService;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

@Service
public class ViolationInfoTbServiceImpl implements ViolationInfoTbService {

    @Resource
    private ViolationInfoTbMapper violationInfoTbMapper;

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return delete count
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return violationInfoTbMapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入（新增）
     *
     * @param record 新增对象
     * @return insert count
     */
    @Override
    public int insert(ViolationInfoTb record) {
        return violationInfoTbMapper.insert(record);
    }

    /**
     * 选择性插入 （某属性为空）
     *
     * @param record 插入对象
     * @return insert count
     */
    @Override
    public int insertSelective(ViolationInfoTb record) {
        return violationInfoTbMapper.insertSelective(record);
    }

    /**
     * 根据主键查找
     *
     * @param id 主键
     * @return ViolationInfoTb 封装好的对象
     */
    @Override
    public ViolationInfoTb selectByPrimaryKey(Integer id) {
        return violationInfoTbMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键选择性更新
     *
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKeySelective(ViolationInfoTb record) {
        return violationInfoTbMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键更新
     *
     * @param record 更新对象
     * @return update count
     */
    @Override
    public int updateByPrimaryKey(ViolationInfoTb record) {
        return violationInfoTbMapper.updateByPrimaryKey(record);
    }

    /**
     * 查找所有违章信息
     *
     * @return List<ViolationInfoTb>
     */
    @Override
    public List<ViolationInfoTb> findAll() {
        return violationInfoTbMapper.findAll();
    }

    /**
     * 根据驾驶证信息查找所有
     *
     * @param driverLicense 驾驶证
     * @return List<ViolationInfoTb>
     */
    @Override
    public List<ViolationInfoTb> findByDriverLicense(String driverLicense) {
        return null;
    }
}
