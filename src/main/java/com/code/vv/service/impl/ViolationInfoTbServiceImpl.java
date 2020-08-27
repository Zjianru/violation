package com.code.vv.service.impl;

import com.code.vv.common.VoTransfer;
import com.code.vv.mapper.ViolationContextTbMapper;
import com.code.vv.mapper.ViolationInfoTbMapper;
import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationInfoTb;
import com.code.vv.service.ViolationInfoTbService;
import com.code.vv.vo.ViolationDetails;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    @Resource
    private ViolationContextTbMapper violationContextTbMapper;

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
        return violationInfoTbMapper.findByDriverLicense(driverLicense);
    }

    /**
     * 分页
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return PageInfo
     */

    @Override
    public PageInfo manageList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ViolationInfoTb> infoList = violationInfoTbMapper.findAll();
        List<ViolationContextTb> contextList = violationContextTbMapper.findAll();
        List<ViolationDetails> violationDetails = VoTransfer.detailVoTransfer(infoList, contextList);
        PageInfo pageInfo = new PageInfo(infoList);
        pageInfo.setList(violationDetails);
        return pageInfo;
    }

    /**
     * 在某段时间范围内某驾驶证的违章信息
     * @param minTime 从之前的什么时间开始算起
     * @param maxTime 当前时间
     * @param driverLicense 驾驶证信息
     * @return List<ViolationInfoTb>
     */
    @Override
    public List<ViolationInfoTb> findAllByTimeBetweenAndDriverLicense(Date minTime, Date maxTime, String driverLicense) {
        return violationInfoTbMapper.findAllByTimeBetweenAndDriverLicense(minTime, maxTime, driverLicense);
    }
}
