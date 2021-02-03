package com.registe.brick.computerbrick.controller;

import com.registe.brick.computerbrick.entity.Computer;
import com.registe.brick.computerbrick.service.imp.ComputService;
import com.registe.brick.userbrick.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 2021/2/3
 * @author fengjiale
 */
@Controller
@RequestMapping("/compute")
public class ComputController {

    @Autowired
    private ComputService computService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public void insertUser() {

        List<Computer> computerList = getList();

        computerList.stream().forEach(c -> {
            int addRes = computService.insertUser(c);
            System.out.println(c.getName()+"   ---新增结果---  "+addRes);
        });
    }


    @RequestMapping(value = "/deletebyid", method = RequestMethod.GET)
    public void deleteById() {

        String delId = "38395528-a536-4b34-92ae-24f32669b6f0";
        int delRes = computService.deleteByPrimaryKey(delId);
        System.out.println("删除结果---   "+delRes);
    }


    @RequestMapping(value = "/updatebyid", method = RequestMethod.GET)
    public void updateById() {

        Computer computer4 = new Computer();
        computer4.setId("c98d5437-32a4-4499-be80-e40bca4db750");
        computer4.setName("华硕");
        computer4.setType("飞行堡垒22");
        computer4.setCreatetime(System.currentTimeMillis());

        int upRes = computService.updateByPrimaryKey(computer4);
        System.out.println("更新结果---   "+upRes);

    }


    @RequestMapping(value = "/selectbyexample", method = RequestMethod.GET)
    public void selectByExample() {

        Example example = new Example(Computer.class);
        Example.Criteria criteria =  example.createCriteria();
        criteria.andGreaterThan("createtime",1612316298151L);
        example.and(criteria);

        List<Computer> computerList = computService.selectByExample(example);

        computerList.stream().forEach(c -> {
            System.out.println(c.getName());
        });
    }

    public static List<Computer> getList(){
        Computer computer = new Computer();
        computer.setId(UUID.randomUUID().toString());
        computer.setName("惠普");
        computer.setType("暗影精灵Air");
        computer.setMemory(128);
        computer.setScreen(12);
        computer.setCreatetime(System.currentTimeMillis());

        Computer computer1 = new Computer();
        computer1.setId(UUID.randomUUID().toString());
        computer1.setName("Mac");
        computer1.setType("MacBook Pro");
        computer1.setMemory(128);
        computer1.setScreen(24);

        computer1.setCreatetime(System.currentTimeMillis());


        Computer computer2 = new Computer();
        computer2.setId(UUID.randomUUID().toString());
        computer2.setName("联想");
        computer2.setType("拯救者");
        computer2.setMemory(64);
        computer2.setScreen(24);
        computer2.setCreatetime(System.currentTimeMillis());


        Computer computer3 = new Computer();
        computer3.setId(UUID.randomUUID().toString());
        computer3.setName("Mac");
        computer3.setType("MacBook Pro");
        computer3.setMemory(512);
        computer3.setScreen(32);
        computer3.setCreatetime(System.currentTimeMillis());


        Computer computer4 = new Computer();
        computer4.setId(UUID.randomUUID().toString());
        computer4.setName("华硕");
        computer4.setType("飞行堡垒");
        computer4.setMemory(256);
        computer4.setScreen(32);
        computer4.setCreatetime(System.currentTimeMillis());


        List<Computer> computerList = Arrays.asList(computer,computer1,computer2,computer3,computer4);

        return computerList;
    }

}
