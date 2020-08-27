package com.code.vv.service;

import java.util.List;

import com.code.vv.model.ViolationInfoTb;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created on 2020/8/24.
 * com.code.vv.service
 *
 * @author Zjianru
 */

public interface ViolationInfoTbService {

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
    int insert(ViolationInfoTb record);
    /**
     * 选择性插入 （某属性为空）
     *
     * @param record 插入对象
     * @return insert count
     */
    int insertSelective(ViolationInfoTb record);
    /**
     * 根据主键查找
     *
     * @param id 主键
     * @return ViolationInfoTb 封装好的对象
     */
    ViolationInfoTb selectByPrimaryKey(Integer id);
    /**
     * 根据主键选择性更新
     *
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKeySelective(ViolationInfoTb record);
    /**
     * 根据主键更新
     *
     * @param record 更新对象
     * @return update count
     */
    int updateByPrimaryKey(ViolationInfoTb record);
    /**
     * 查找所有违章信息
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findAll();

    /**
     * 根据驾驶证信息查找所有
     * @param driverLicense 驾驶证
     * @return List<ViolationInfoTb>
     */
    List<ViolationInfoTb> findByDriverLicense(String driverLicense);

    /**
     * 分页
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo manageList(Integer pageNum, Integer pageSize);
}
