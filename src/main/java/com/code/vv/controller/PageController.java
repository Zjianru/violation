package com.code.vv.controller;

import com.code.vv.service.ViolationContextTbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2020/8/24.
 * com.code.vv.controller
 *
 * @author Zjianru
 */
@Controller
public class TestController {

    ViolationContextTbService contextTbService;

    public TestController(ViolationContextTbService contextTbService) {
        this.contextTbService = contextTbService;
    }

    /**
     * Json 返回 Test
     *
     * @return String For Json
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String testMethod() {
        return "Test Hello";
    }

    /**
     * Thymeleaf Page 返回 Test
     *
     * @return redirect to Thymeleaf Page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pageTest")
    public String pageTestMethod() {
        return "TestHello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/query")
    @ResponseBody
    public String queryTestMethod() {
        return contextTbService.selectByPrimaryKey(1).toString();
    }
}