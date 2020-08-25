package com.code.vv.web.controller;

import com.code.vv.common.Const;
import com.code.vv.model.ViolationUserTb;
import com.code.vv.service.ViolationUserTbService;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created on 2020/8/25.
 * com.code.vv.controller
 *
 * @author Zjianru
 */
@Controller
public class LoginController {

    private final ViolationUserTbService userTbService;
    public LoginController(ViolationUserTbService userTbService) {
        this.userTbService = userTbService;
    }


    /**
     * login 页面访问
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET,value = "/loginPage")
    public ModelAndView  loginPage(ModelAndView modelAndView){
        modelAndView.setViewName("loginPage");
        return modelAndView;
    }

    /**
     * 用户登录 前台传值后台校验
     * 校验成功携带用户信息跳新页面，校验失败不带信息跳回原页面
     * @param modelAndView modelAndView
     * @param name name
     * @param password password
     * @param session session
     * @return String
     */
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ModelAndView  login(ModelAndView modelAndView, @Param("name") String name, @Param("password") String password, HttpSession session){
        // 简单判空
        if (name != null && password != null){
            ViolationUserTb user = userTbService.login(name, password);
            if (user == null){
                modelAndView.setViewName("loginPage");
                return modelAndView;
            }
           // 普通用户
            if (user.getRole() == 1){
                session.setAttribute(Const.USER_SESSION_KEY,user);
                modelAndView.setViewName("plainBackIndex");
                return modelAndView;
            }
            // Admin 用户
            if (user.getRole() == 0){
                session.setAttribute(Const.USER_SESSION_KEY,user);
                modelAndView.setViewName("adminBackIndex");
                return modelAndView;
            }
            // 乱填的凭证，转发至 error 页面
        }else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

}
