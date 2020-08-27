package com.code.vv.web.controller;

import com.code.vv.common.VoTransfer;
import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationInfoTb;
import com.code.vv.service.ViolationContextTbService;
import com.code.vv.service.ViolationInfoTbService;
import com.code.vv.vo.ViolationDetails;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(method = RequestMethod.GET, value = "/plain/InfoList")
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


}

