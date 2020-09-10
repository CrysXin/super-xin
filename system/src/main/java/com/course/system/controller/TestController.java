package com.course.system.controller;

import com.course.server.pojo.Test;


import com.course.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZHX on 2020/9/6.
 */
@RestController

public class TestController {
    /**
     * Created by ZHX on 2020/9/6.
     */

    @Resource
    TestService testService;



    @RequestMapping("/test")
    public String test(){
        return "success";
    }




    @RequestMapping("/list")
    public List<Test> list1(){
        return testService.list();
    }

}
