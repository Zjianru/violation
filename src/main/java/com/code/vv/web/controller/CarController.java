package com.code.vv.web.controller;

import com.code.vv.common.Const;
import com.code.vv.model.ViolationCarTb;
import com.code.vv.model.ViolationUserTb;
import com.code.vv.service.ViolationCarTbService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2020/8/25.
 * com.code.vv.web.controller
 * 汽车 相关业务控制 Controller
 *
 * @author Zjianru
 */
@Controller
public class CarController {
    final
    ViolationCarTbService carService;

    public CarController(ViolationCarTbService carService) {
        this.carService = carService;
    }

    /**
     * 新增车辆信息
     *
     * @param session      session
     * @param licensePlate 车牌
     * @param color        车身颜色
     * @param seatNumber   限乘人数
     * @return String 跳转页面地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/createCar")
    public String createCarInfo(HttpSession session,
                                @Param("licensePlate") String licensePlate,
                                @Param("color") String color,
                                @Param("seatNumber") int seatNumber) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (userInfo.getRole() != 1) {
            return "/error";
        } else {
            List<ViolationCarTb> listByLicensePlate = carService.selectByLicensePlate(licensePlate);
            if (listByLicensePlate.size() == 0) {
                ViolationCarTb car = new ViolationCarTb();
                car.setLicensePlate(licensePlate);
                car.setColor(color);
                car.setSeatNumber(seatNumber);
                carService.insert(car);
                return "redirect:/carInfo";
            } else {
                return "/error";
            }
        }
    }

    /**
     * 车辆信息查看
     *
     * @param model   model
     * @param session session
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/carInfo")
    public String carInfo(Model model, HttpSession session) {
        ViolationUserTb userInfo = (ViolationUserTb) session.getAttribute(Const.USER_SESSION_KEY);
        if (userInfo.getRole() != 1) {
            return "/error";
        } else {
            model.addAttribute("carList", carService.findAll());
            return "/carInfoPage";
        }
    }

}