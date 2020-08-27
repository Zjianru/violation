package com.code.vv.web.controller;

import com.code.vv.common.Const;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
     * @param model model
     * @param pageNum 分页数
     * @param pageSize 每页数据量
     * @return 页面跳转地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/plain/info/list")
    public String userList(Model model,
                           @RequestParam(required = false, defaultValue = "2", value = "pageNum") Integer pageNum,
                           @RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize) {
        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum, pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<ViolationInfoTb> infoList = infoService.findAll();
            List<ViolationContextTb> contextList = contextService.findAll();
            List<ViolationDetails> violationDetails = VoTransfer.detailVoTransfer(infoList,contextList);
            System.out.println("分页数据：" + violationDetails);
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<ViolationDetails> pageInfo = new PageInfo<>(violationDetails, pageSize);
            //4.使用 model 传参数回前端
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("detailList", violationDetails);
        } finally {
            //清理 ThreadLocal 存储的分页参数,保证线程安全
            PageHelper.clearPage();
        }
        return "/plainInfoList";
    }

    /**
     * 查询所有违章内容，携带跳转至新增违章信息页面
     * @param model model
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/plain/Info/createPage")
    public String plainInfoCreatePageMethod(Model model, HttpSession session) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        }else {
            List<ViolationContextTb> contextList = contextService.findAll();
            model.addAttribute("contextList",contextList);
            return "/plainInfoCreatePage";
        }
    }

    /**
     * TODO 完成逻辑填充
     * @param model model
     * @param session session
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/plain/Info/create")
    public String plainInfoCreateMethod(Model model, HttpSession session,
                                        @RequestParam(value = "context") String context,
                                        @RequestParam(value = "licensePlate") String licensePlate,
                                        @RequestParam(value = "time") String time,
                                        @RequestParam(value = "place") String place,
                                        @RequestParam(value = "violationContext") String violationContext
                                        ) {
        System.out.println(context+"---"+licensePlate+"---"+time+"---"+place+"---"+violationContext+"---");
        return "redirect:/plain/info/list";
    }

    /**
     * 删除违章信息
     * @param id 待删除违章信息 ID
     * @param session session
     * @return 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/plain/Info/delete/{id}")
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
     * TODO 填充参数和校验逻辑
     * @param session session
     * @return 跳转地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/plain/info/update")
    public String plainInfoUpdateMethod(HttpSession session){
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ROLE)) {
            return "/error";
        } else {
            return "redirect:/plain/info/list";
        }
    }

}

