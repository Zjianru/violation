package com.code.vv.controller;

import com.code.vv.model.ViolationUserTb;
import com.code.vv.service.ViolationUserTbService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET,value = "/loginPage")
    public String loginPage(){
        return "loginPage";
    }


    /**
     * 用户登录 前台传值后台校验
     * 校验成功携带用户信息跳新页面，校验失败不带信息跳回原页面
     * @param request request
     * @param session session
     * @return String
     */
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public String login(HttpServletRequest request , HttpSession session){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (!StringUtils.isNotBlank(userName) && !StringUtils.isNotBlank(password)){
            ViolationUserTb user = userTbService.login(userName, password);
            if (user == null){
                return "redirect:/loginPage";
            }
            session.setAttribute("LoginUser",user);
        }
        return "backIndex";
    }

}
