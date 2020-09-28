package com.course.server.service;

import com.course.server.mapper.TestMapper;
import com.course.server.pojo.Test;
import com.course.server.pojo.TestExample;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZHX on 2020/9/10.
 */
@Service
public class TestService {
    @Resource
    TestMapper testMapper;


    public List<Test> list(){

        return  testMapper.selectByExample(null);
    }
}
