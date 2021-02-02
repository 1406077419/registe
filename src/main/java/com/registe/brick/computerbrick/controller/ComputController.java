package com.registe.brick.computerbrick.controller;

import com.registe.brick.computerbrick.entity.Computer;
import com.registe.brick.computerbrick.service.imp.ComputService;
import com.registe.brick.userbrick.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/compute")
public class ComputController {

    @Autowired
    private ComputService computService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public void insertUser() {

        Computer computer = new Computer();
        computer.setId(UUID.randomUUID().toString());
        computer.setName("惠普");
        computer.setType("暗影精灵Air");
        computService.insertUser(computer);
    }


    @RequestMapping(value = "/deletebyid", method = RequestMethod.GET)
    public void deleteById() {

        //@RequestParam("token") String token
        String auth = AuthUtil.authMap.get("token");//传的token值
        AuthUtil.delToken(auth.split(",")[0], auth.split(",")[1]);
    }


    @RequestMapping(value = "/updatebyid", method = RequestMethod.GET)
    public void updateById() {

        //@RequestParam("token") String token
        String auth = AuthUtil.authMap.get("token");//传的token值
        AuthUtil.delToken(auth.split(",")[0], auth.split(",")[1]);
    }


    @RequestMapping(value = "/selectbyexample", method = RequestMethod.GET)
    public void selectByExample() {

        //@RequestParam("token") String token
        String auth = AuthUtil.authMap.get("token");//传的token值
        AuthUtil.delToken(auth.split(",")[0], auth.split(",")[1]);
    }

}
