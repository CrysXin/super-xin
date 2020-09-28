package com.course.business.controller.admin;

import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.SectionService;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Created by ZHX on 2020/9/6.
 */

@RestController
@RequestMapping("/admin/section")
public class SectionController {
    /**
     * Created by ZHX on 2020/9/6.
     */

    private static final Logger LOG = LoggerFactory.getLogger(SectionController.class);

    public static final String BUSINESS_NAME = "小节";
    @Resource
    SectionService sectionService;


//
//    @RequestMapping("/a")
//    public String section(){
//        return "success";
//    }




    @RequestMapping("/list")
    public ResponseDto list1(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        sectionService.list(pageDto);
        LOG.info("pageDto: {}",pageDto);
        responseDto.setContent(pageDto);
        return  responseDto;
    }
    @PostMapping("/save")
    public ResponseDto list1(@RequestBody SectionDto sectionDto){
        LOG.info("sectionDto: {}",sectionDto);


        //保存校验


        ResponseDto responseDto = new ResponseDto();
        sectionService.save(sectionDto);
        responseDto.setContent(sectionDto);
        return responseDto;


//        ResponseDto responseDto = new ResponseDto();
//        sectionService.save(sectionDto);
//
//        responseDto.setContent(sectionDto);
//        return  responseDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String  id){
        ResponseDto responseDto = new ResponseDto();
        sectionService.delete(id);
        LOG.info("id: {}",id);
        return  responseDto;
    }

}
