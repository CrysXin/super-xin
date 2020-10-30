package com.course.business.controller.admin;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.ChapterService;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Created by ZHX on 2020/9/6.
 */

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    /**
     * Created by ZHX on 2020/9/6.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

    public static  final  String BUSINESS_NAME = "大章";
    @Resource
    ChapterService chapterService;


//
//    @RequestMapping("/a")
//    public String chapter(){
//        return "success";
//    }




    @RequestMapping("/list")
    public ResponseDto list1(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        chapterService.list(pageDto);
        LOG.info("pageDto: {}",pageDto);
        responseDto.setContent(pageDto);
        return  responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {
        // 保存校验
        ValidatorUtil.require(chapterDto.getName(), "名称");
        ValidatorUtil.require(chapterDto.getCourseId(), "课程ID");
        ValidatorUtil.length(chapterDto.getCourseId(), "课程ID", 1, 8);

        ResponseDto responseDto = new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String  id){
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        LOG.info("id: {}",id);
        return  responseDto;
    }

}
