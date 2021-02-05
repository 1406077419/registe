package com.registe.brick.userbrick.controller;

import com.registe.brick.userbrick.service.UserServiceTk;
import com.registe.brick.userbrick.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2021/2/1  fengjiale
 */
@Controller
@RequestMapping("tkuser")
public class UserTkController {

    @Autowired
    private UserServiceTk userService;

    /**
     * 条件查询
     */
    @GetMapping("getAll")
    public void getAll() {
        userService.allFUnctions();
    }

    /**
     * 分页查询
     */
    @GetMapping("getpage")
    public void getPage() {
        int pageNum = 1;
        int pageSize = 3;
        PageUtil pageUtil = new PageUtil(pageNum, pageSize);
        userService.getPage(pageUtil);
    }

    /**
     * count
     */
    @GetMapping("getcount")
    public void getCount() {
        userService.getCountByName("张三");
    }

    /**
     * max
     */
    @GetMapping("getmax")
    public void getMax() {
        userService.getMax();
    }


}
