package com.code.vv.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 2020/8/24.
 * com.code.vv.controller
 * 页面跳转相关逻辑
 *
 * @author Zjianru
 */
@Controller
public class PageController {

    @RequestMapping(method = RequestMethod.GET, value = "/admin/leftNavigation")
    public String adminNavigationMethod() {
        return "/adminLeftNavigation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/body")
    public String adminBodyMethod() {
        return "/adminBody";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/backIndex")
    public String adminBackIndexMethod() {
        return "/adminBackIndex";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/plain/leftNavigation")
    public String plainNavigationMethod() {
        return "/plainLeftNavigation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/plain/body")
    public String plainBodyMethod() {
        return "/plainBody";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/plain/backIndex")
    public String plainBackIndexMethod() {
        return "/plainBackIndex";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/carInsert")
    public String insertCarMethod() {
        return "/carInsert";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/anonymous")
    public String anonymousMethod() {
        return "/anonymousList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/changePassPage")
    public String changePassPage() {
        return "/changePassPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userAddPage")
    public String addUserMethod() {
        return "/adminUserAddPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/context/create")
    public String addContextMethod() {
        return "/adminContextCreatePage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error")
    public String errorPageMethod() {
        return "/error";
    }

}