package com.course.${module}.controller.admin;

import com.course.server.dto.${Domain}Dto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.${Domain}Service;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Created by ZHX on 2020/9/6.
 */

@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {
    /**
     * Created by ZHX on 2020/9/6.
     */

    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);

    public static final String BUSINESS_NAME = "${tableNameCn}";
    @Resource
    ${Domain}Service ${domain}Service;


//
//    @RequestMapping("/a")
//    public String ${domain}(){
//        return "success";
//    }




    @RequestMapping("/list")
    public ResponseDto list1(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.list(pageDto);
        LOG.info("pageDto: {}",pageDto);
        responseDto.setContent(pageDto);
        return  responseDto;
    }
    @PostMapping("/save")
    public ResponseDto list1(@RequestBody ${Domain}Dto ${domain}Dto){
        LOG.info("${domain}Dto: {}",${domain}Dto);


        //保存校验


        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;


//        ResponseDto responseDto = new ResponseDto();
//        ${domain}Service.save(${domain}Dto);
//
//        responseDto.setContent(${domain}Dto);
//        return  responseDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String  id){
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.delete(id);
        LOG.info("id: {}",id);
        return  responseDto;
    }

}
