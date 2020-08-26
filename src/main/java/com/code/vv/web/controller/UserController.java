package com.code.vv.web.controller;

import com.code.vv.common.Const;
import com.code.vv.model.ViolationUserTb;
import com.code.vv.service.ViolationUserTbService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created on 2020/8/26.
 * com.code.vv.web.controller
 * 用户相关业务控制 Controller
 *
 * @author Zjianru
 */
@Controller
public class UserController {
    final
    ViolationUserTbService userTbService;

    public UserController(ViolationUserTbService userTbService) {
        this.userTbService = userTbService;
    }

    /**
     * 修改密码
     *
     * @param pass    原密码
     * @param newPass 新密码
     * @param session session
     * @return String 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/user/changePass")
    public String changePass(@Param("pass") String pass,
                             @Param("newPass") String newPass,
                             HttpSession session) {
        ViolationUserTb user = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        // 原密码校验
        if (pass.equals(user.getPassword())) {
            user.setPassword(newPass);
            userTbService.updateByPrimaryKeySelective(user);
            return "/loginPage";
        } else {
            return "/error";
        }
    }

    /**
     * 新增普通用户
     *
     * @param name name
     * @param pass pass
     * @return String 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/user/addUser")
    public String addUser(@Param("name") String name, @Param("pass") String pass) {
        ViolationUserTb user = new ViolationUserTb();
        user.setName(name);
        user.setPassword(pass);
        user.setRole(Const.USER_ROLE);
        user.setStatus(Const.USER_STATUS);
        userTbService.insert(user);
        return "redirect:/user/Info";
    }

    /**
     * 所有用户信息
     *
     * @param model   model
     * @param session session
     * @return String 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user/Info")
    public String userInfo(Model model, HttpSession session) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (userInfo.getRole() != 0) {
            return "/error";
        } else {
            model.addAttribute("userList", userTbService.findAll());
            return "/adminUserOperatePage";
        }
    }

    /**
     * 封存用户
     *
     * @param id      被封存用户 ID
     * @param session session
     * @return String 跳转页面地址
     */
    @RequestMapping(value = "/user/archive/{id}", method = RequestMethod.GET)
    public String archiveUser(@PathVariable("id") String id, HttpSession session) {
        Integer deleteId = Integer.valueOf(id);
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (userInfo.getRole() != 0) {
            return "/error";
        } else {
            ViolationUserTb user = new ViolationUserTb();
            user.setId(deleteId);
            user.setStatus(Const.USER_DELETE_STATUS);
            userTbService.updateByPrimaryKeySelective(user);
            return "forward:/user/Info";
        }
    }

    /**
     * 启用用户
     *
     * @param id      被启用用户 ID
     * @param session session
     * @return String 跳转页面地址
     */
    @RequestMapping(value = "/user/enable/{id}", method = RequestMethod.GET)
    public String enableUser(@PathVariable("id") String id, HttpSession session) {
        Integer deleteId = Integer.valueOf(id);
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (userInfo.getRole() != 0) {
            return "/error";
        } else {
            ViolationUserTb user = new ViolationUserTb();
            user.setId(deleteId);
            user.setStatus(Const.USER_STATUS);
            userTbService.updateByPrimaryKeySelective(user);
            return "forward:/user/Info";
        }
    }

}
