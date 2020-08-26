package com.code.vv.web.controller;

import com.code.vv.common.Const;
import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationUserTb;
import com.code.vv.service.ViolationContextTbService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created on 2020/8/26.
 * com.code.vv.web.controller
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
     * @param session session
     * @param context context 违章内容，实际指违章项目
     * @param deduction deduction 扣分情况
     * @param amerce amerce 罚款情况
     * @return String 跳转页面 URL
     */
    @RequestMapping(method = RequestMethod.POST, value = "/admin/context/create")
    public String adminContextCreate(HttpSession session,
                                     @Param("context") String context,
                                     @Param("deduction") String deduction,
                                     @Param("amerce") String amerce) {
        // 权限判定
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (userInfo.getRole().equals(Const.USER_ADMIN_ROLE)) {
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
     *
     * @param model   model
     * @param session session
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/admin/context/findAll")
    public String adminContextFindAll(Model model, HttpSession session) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (userInfo.getRole().equals(Const.USER_ADMIN_ROLE)) {
            return "/error";
        } else {
            model.addAttribute("contextList", contextTbService.findAll());
            return "/adminContextDemo";
        }
    }

// adminContextUpdate 更改Context
// adminContextDelete 删除Context
}
