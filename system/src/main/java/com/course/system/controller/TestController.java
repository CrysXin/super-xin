package com.course.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZHX on 2020/9/6.
 */
@RestController
public class TestController {
    /**
     * Created by ZHX on 2020/9/6.
     */

    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}
