package com.code.vv.web.controller;

import com.code.vv.common.Const;
import com.code.vv.common.DateFormat;
import com.code.vv.common.VoTransfer;
import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationInfoTb;
import com.code.vv.model.ViolationUserTb;
import com.code.vv.service.ViolationContextTbService;
import com.code.vv.service.ViolationInfoTbService;
import com.code.vv.vo.ViolationDetails;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created on 2020/8/26.
 * com.code.vv.web.controller
 * 违章信息 相关业务控制 Controller
 *
 * @author Zjianru
 */
@Controller
public class InfoController {

    final
    ViolationInfoTbService infoService;
    final
    ViolationContextTbService contextService;

    public InfoController(ViolationInfoTbService infoService, ViolationContextTbService contextService) {
        this.infoService = infoService;
        this.contextService = contextService;
    }

    /**
     * 分页查询 Info
     *
     * @param model    model
     * @param pageNum  分页数
     * @param pageSize 每页数据量
     * @return 页面跳转地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/plain/info/list")
    public String userList(Model model,
                           @RequestParam(defaultValue = "1", value = "pageNum", required = false) Integer pageNum,
                           @RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize) {
        PageInfo pageInfo = infoService.manageList(pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("details", VoTransfer.detailVoTransfer(infoService.findAll(), contextService.findAll()));
        return "/plainInfoList";
    }

    /**
     * 查询所有违章内容，携带跳转至新增违章信息页面
     *
     * @param model model
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/plain/Info/createPage")
    public String plainInfoCreatePageMethod(Model model, HttpSession session) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        } else {
            List<ViolationContextTb> contextList = contextService.findAll();
            model.addAttribute("contextList", contextList);
            return "/plainInfoCreatePage";
        }
    }


    /**
     * 新增违章信息记录
     *
     * @param session          session
     * @param licensePlate     车辆车牌
     * @param time             违章时间
     * @param place            违章地点
     * @param violationContext context 的 ID ，做关联
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/plain/Info/create")
    public String plainInfoCreateMethod(HttpSession session,
                                        @RequestParam(value = "licensePlate") String licensePlate,
                                        @RequestParam(value = "time") String time,
                                        @RequestParam(value = "place") String place,
                                        @RequestParam(value = "violationContext") String violationContext) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        } else {
            ViolationInfoTb violationInfoTb = new ViolationInfoTb();
            violationInfoTb.setLicensePlate(licensePlate);
            violationInfoTb.setTime(DateFormat.stringToDate(time));
            violationInfoTb.setPlace(place);
            List<ViolationContextTb> byContext = contextService.findByContext(violationContext);
            ViolationContextTb contextTb = byContext.get(0);
            violationInfoTb.setViolationContext(contextTb.getId());
            if (contextTb.getDeduction() != 0) {
                violationInfoTb.setDeductionStatus(1);
            } else {
                violationInfoTb.setDeductionStatus(0);
            }
            if (contextTb.getAmerce().intValue() > 0) {
                violationInfoTb.setAmerceStatus(1);
            } else {
                violationInfoTb.setAmerceStatus(0);
            }
            infoService.insert(violationInfoTb);
            return "redirect:/plain/info/list";
        }
    }

    /**
     * 删除违章信息
     *
     * @param id      待删除违章信息 ID
     * @param session session
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/plain/info/delete/{id}")
    public String plainInfoDeleteMethod(@PathVariable("id") String id, HttpSession session) {
        Integer deleteId = Integer.valueOf(id);
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        } else {
            infoService.deleteByPrimaryKey(deleteId);
            return "redirect:/plain/info/list";
        }
    }

    /**
     * 修改违章信息并分流
     * 获取关键违章信息 ID,查找违章信息，跳转到修改页
     *
     * @param session session
     * @return 跳转地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/plain/info/update/{id}")
    public String plainInfoUpdateLoadBalanceMethod(@PathVariable("id") String id, HttpSession session, Model model) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        } else {
            ViolationInfoTb infoTb = infoService.selectByPrimaryKey(Integer.valueOf(id));
            ViolationContextTb contextTb = contextService.selectByPrimaryKey(infoTb.getViolationContext());
            ViolationDetails details = VoTransfer.detailVoTransfer(infoTb, contextTb);
            if (infoTb.getDeductionStatus() != 1) {
                // 不扣分，不需带出驾驶证填写框
                model.addAttribute("details", details);
                return "/plainInfoUpdatePage";
            } else {
                // 扣分，需带出驾驶证填写框并做校验
                model.addAttribute("details", details);
                return "/plainInfoUpdatePageWDL";
            }
        }
    }

    /**
     * 拿到违章信息 ID 和罚款金额
     * 做校验，金额不对不给过
     * 过了就改罚款状态，算是已处理
     *
     * @param session session
     * @param id      违章信息 ID
     * @param amerce  罚款金额
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/plain/info/update")
    public String plainInfoUpdateMethod(HttpSession session,
                                        @RequestParam(value = "id") String id,
                                        @RequestParam(value = "amerce") String amerce
    ) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        } else {
            ViolationInfoTb infoModel = infoService.selectByPrimaryKey(Integer.valueOf(id));
            ViolationContextTb contextModel = contextService.selectByPrimaryKey(infoModel.getViolationContext());
            if (!amerce.equals(contextModel.getAmerce().toString())) {
                return "/error";
            } else {
                ViolationInfoTb updateModel = new ViolationInfoTb();
                updateModel.setId(infoModel.getId());
                updateModel.setAmerceStatus(0);
                infoService.updateByPrimaryKeySelective(updateModel);
                return "redirect:/plain/info/list";
            }
        }
    }

    /**
     * 更新违章信息，前置处理已经校验过驾照信息
     * 拿到 id 与金额，做校验
     * 更新驾照信息
     *
     * @param session session
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/plain/info/updateWDL")
    public String plainInfoUpdateWithDriverLicenseMethod(HttpSession session,
                                                         @RequestParam(value = "id") String id,
                                                         @RequestParam(value = "amerce") String amerce,
                                                         @RequestParam(value = "driverLicense") String driverLicense) {
        System.out.println(id + "---amerce:---" + amerce + "driverLicense-=-" + driverLicense);
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        } else {
            ViolationInfoTb infoModel = infoService.selectByPrimaryKey(Integer.valueOf(id));
            ViolationContextTb contextModel = contextService.selectByPrimaryKey(infoModel.getViolationContext());
            if (!amerce.equals(contextModel.getAmerce().toString())) {
                return "/error";
            } else {
                ViolationInfoTb updateModel = new ViolationInfoTb();
                updateModel.setId(infoModel.getId());
                updateModel.setAmerceStatus(0);
                updateModel.setDriverLicense(driverLicense);
                infoService.updateByPrimaryKeySelective(updateModel);
                return "redirect:/plain/info/list";
            }
        }
    }

    /**
     * 根据驾驶证获得扣分总数
     *
     * @param driverLicense 驾驶证
     * @return List<String> 总扣分
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sumDriverLicense")
    @ResponseBody
    @CrossOrigin
    public List<String> findDeductionByContext(@RequestParam(value = "driverLicense") String driverLicense) {
        // 查到从现在往前数一年之内的违章信息
        Date maxTime = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(maxTime);
        cal.add(Calendar.YEAR, -1);
        Date minTime = cal.getTime();
        List<ViolationInfoTb> byDriverLicense = infoService.findAllByTimeBetweenAndDriverLicense(minTime, maxTime, driverLicense);
        int count = 0;
        List<String> list = new ArrayList<>();
        // 首次被扣分
        if (byDriverLicense == null) {
            list.add(String.valueOf(0));
        } else {
            for (ViolationInfoTb violationInfoTb : byDriverLicense) {
                ViolationContextTb contextTb = contextService.selectByPrimaryKey(violationInfoTb.getViolationContext());
                count += contextTb.getDeduction();
            }
            list.add(String.valueOf(count));
        }
        return list;
    }


    /**
     * 查询所有违章记录 带数据进页面 分页
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @param licensePlate
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/anonymous/queryAll")
    public String anonymousQueryAll(Model model,
                                    @RequestParam(defaultValue = "1", value = "pageNum", required = false) Integer pageNum,
                                    @RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize,
                                    @RequestParam(value = "licensePlate") String licensePlate) {
        PageInfo pageInfo = infoService.anonymousQueryAllList(pageNum, pageSize, licensePlate);
        PageHelper.startPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("details", VoTransfer.detailVoTransfer(infoService.findAllByLicensePlate(licensePlate), contextService.findAll()));
        return "/anonymousInfoList";
    }


    /**
     * 查询未处理违章记录 带数据进页面 分页
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @param licensePlateForQueryNoAmerce
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/anonymous/queryNoAmerce")
    public String anonymousQueryNoAmerce(Model model,
                                         @RequestParam(defaultValue = "1", value = "pageNum", required = false) Integer pageNum,
                                         @RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize,
                                         @RequestParam(value = "licensePlateForQueryNoAmerce") String licensePlateForQueryNoAmerce) {
        PageInfo pageInfo = infoService.anonymousQueryWithAmerceList(pageNum, pageSize, licensePlateForQueryNoAmerce, Const.NO_AMERCE);
        PageHelper.startPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("details", VoTransfer.detailVoTransfer(infoService.findAllByLicensePlateAndAmerceStatus(licensePlateForQueryNoAmerce, Const.NO_AMERCE), contextService.findAll()));
        return "/anonymousNoAmerceInfoList";
    }

    /**
     * 查询已处理违章记录 带数据进页面 分页
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @param licensePlateForQueryWithAmerce
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/anonymous/queryWithAmerce")
    public String anonymousQueryWithAmerce(Model model,
                                           @RequestParam(defaultValue = "1", value = "pageNum", required = false) Integer pageNum,
                                           @RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize,
                                           @RequestParam(value = "licensePlateForQueryWithAmerce") String licensePlateForQueryWithAmerce) {
        PageInfo pageInfo = infoService.anonymousQueryWithAmerceList(pageNum, pageSize, licensePlateForQueryWithAmerce, Const.NEED_AMERCE);
        PageHelper.startPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("details", VoTransfer.detailVoTransfer(infoService.findAllByLicensePlateAndAmerceStatus(licensePlateForQueryWithAmerce, Const.NEED_AMERCE), contextService.findAll()));
        return "/anonymousWithAmerceInfoList";
    }


    /**
     * 根据 ID 查完整信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/anonymous/info/{id}")
    public String anonymousInfoPageMethod(@PathVariable("id") String id, Model model) {
        ViolationInfoTb infoTb = infoService.selectByPrimaryKey(Integer.valueOf(id));
        ViolationContextTb contextTb = contextService.selectByPrimaryKey(infoTb.getViolationContext());
        ViolationDetails details = VoTransfer.detailVoTransfer(infoTb, contextTb);
        model.addAttribute("detail", details);
        return "/anonymousInfoPage";
    }


}

