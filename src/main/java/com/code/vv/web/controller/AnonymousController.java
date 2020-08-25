package com.code.vv.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/8/25.
 * com.code.vv.web.controller
 *
 * @author Zjianru
 */
@RestController
public class AnonymousController {

    @RequestMapping(method = RequestMethod.GET, value = "/getAnonymousList")
    @ResponseBody
    public String getAnonymousListMethod() {
        return "anonymousList";
    }
}
