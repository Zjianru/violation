package com.code.vv.web.controller;

import com.code.vv.common.Const;
import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationUserTb;
import com.code.vv.service.ViolationContextTbService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/8/26.
 * com.code.vv.web.controller
 * 违章内容控制 Controller
 *
 * @author Zjianru
 */
@Controller
public class ContextController {

    final
    ViolationContextTbService contextTbService;

    public ContextController(ViolationContextTbService contextTbService) {
        this.contextTbService = contextTbService;
    }


    /**
     * adminContextCreate
     * 创建 Context
     *
     * @param session   session
     * @param context   context 违章内容，实际指违章项目
     * @param deduction deduction 扣分情况
     * @param amerce    amerce 罚款情况
     * @return String 跳转页面 URL
     */
    @RequestMapping(method = RequestMethod.POST, value = "/admin/context/create")
    public String adminContextCreate(HttpSession session,
                                     @Param("context") String context,
                                     @Param("deduction") String deduction,
                                     @Param("amerce") String amerce) {
        // 权限判定
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ADMIN_ROLE)) {
            return "/error";
        }
        // 违章描述唯一
        if (contextTbService.findByContext(context).size() != 0) {
            return "/error";
        }
        //创建时需判定扣分与罚款必须有一个填写
        if (deduction == null || deduction.length() <= 0) {
            deduction = "0";
        }
        if (amerce == null || amerce.length() <= 0) {
            amerce = "0";
        }
        ViolationContextTb contextObject = new ViolationContextTb();
        contextObject.setContext(context);
        contextObject.setDeduction(Integer.valueOf(deduction));
        contextObject.setAmerce(new BigDecimal(amerce));
        contextTbService.insert(contextObject);
        return "redirect:/admin/context/findAll";

    }


    /**
     * adminContextFindAll
     * 查找当前所有 context 信息
     *
     * @param model   model
     * @param session session
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/admin/context/findAll")
    public String adminContextFindAll(Model model, HttpSession session) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ADMIN_ROLE)) {
            return "/error";
        } else {
            model.addAttribute("contextList", contextTbService.findAll());
            return "/adminContextDemo";
        }
    }


    /**
     * adminContextUpdate
     * 更改 Context
     *
     * @param session   session
     * @param id        待修改 Context 的 id
     * @param context   新的 context
     * @param deduction 新的 deduction
     * @param amerce    新的 amerce
     * @return String
     */
    @RequestMapping(method = RequestMethod.POST, value = "/admin/context/update")
    public String adminContextUpdate(HttpSession session,
                                     @Param("id") String id,
                                     @Param("context") String context,
                                     @Param("deduction") String deduction,
                                     @Param("amerce") String amerce) {
        // 权限判定
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ADMIN_ROLE)) {
            return "/error";
        }
        // 违章描述唯一
        ViolationContextTb selectByPrimaryKey = contextTbService.selectByPrimaryKey(Integer.valueOf(id));

        if (!context.equals(selectByPrimaryKey.getContext()) && contextTbService.findByContext(context).size() >= 1) {
            return "/error";
        }
        //创建时需判定扣分与罚款必须有一个填写
        if (deduction == null || deduction.length() <= 0) {
            deduction = "0";
        }
        if (amerce == null || amerce.length() <= 0) {
            amerce = "0";
        }
        selectByPrimaryKey.setId(Integer.valueOf(id));
        selectByPrimaryKey.setContext(context);
        selectByPrimaryKey.setDeduction(Integer.valueOf(deduction));
        selectByPrimaryKey.setAmerce(new BigDecimal(amerce));
        contextTbService.updateByPrimaryKeySelective(selectByPrimaryKey);
        return "redirect:/admin/context/findAll";
    }


    /**
     * adminContextDelete
     * 删除 Context
     *
     * @param id      待修改 Context 的 id
     * @param session session
     * @return 跳转页面 url
     */
    @RequestMapping(method = RequestMethod.GET, value = "/admin/context/delete/{id}")
    public String adminContextDelete(@PathVariable("id") String id, HttpSession session) {
        // 权限判定
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (!userInfo.getRole().equals(Const.USER_ADMIN_ROLE)) {
            return "/error";
        }
        contextTbService.deleteByPrimaryKey(Integer.valueOf(id));
        return "redirect:/admin/context/findAll";
    }

    /**
     * 找到全部违章内容的描述
     * @return List<String>
     */
    @RequestMapping(method = RequestMethod.GET, value = "/findAllContext")
    @ResponseBody
    @CrossOrigin
    public List<String> findAllContext() {
        List<ViolationContextTb> contexts = contextTbService.findAll();
        ArrayList<String> result = new ArrayList<>();
        for (ViolationContextTb context : contexts) {
            result.add(context.getContext());
        }
        return result;
    }

    /**
     * 根据违章内容描述找到对应的扣分项
     * @param context 违章内容描述
     * @return List<String> 扣分数目
     */
    @RequestMapping(method = RequestMethod.POST, value = "/findDeductionByContext")
    @ResponseBody
    @CrossOrigin
    public List<String> findDeductionByContext(@RequestParam(value = "context") String context){
        List<ViolationContextTb> byContext = contextTbService.findByContext(context);
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(byContext.get(0).getDeduction()));
        return list;
    }

    /**
     * 根据违章内容描述找到对应的罚款项
     * @param context 违章内容描述
     * @return List<String> 罚款数目
     */
    @RequestMapping(method = RequestMethod.POST, value = "/findAmerceByContext")
    @ResponseBody
    @CrossOrigin
    public List<String> findAmerceByContext(@RequestParam(value = "context") String context){
        List<ViolationContextTb> byContext = contextTbService.findByContext(context);
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(byContext.get(0).getAmerce()));
        return list;
    }
}
