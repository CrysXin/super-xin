package com.course.server.service;

import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.dto.ChapterDto;
import com.course.server.pojo.Chapter;
import com.course.server.pojo.ChapterExample;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHX on 2020/9/10.
 */
@Service
public class ChapterService {
    @Resource
    ChapterMapper chapterMapper;


    /**
     * 查询
     */
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();


        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);

        PageInfo<Chapter> pageInfo = new PageInfo(chapterList);
        pageDto.setTotal(pageInfo.getTotal());

        List<ChapterDto> chapterDtoList = new ArrayList<>();
        for (int i = 0; i < chapterList.size(); i++) {
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapterList.get(i),chapterDto);
            chapterDtoList.add(chapterDto);
        }
        pageDto.setList(chapterDtoList);

    }

    /**
     * 保存
     */
    public void save(ChapterDto chapterDto){
        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        if(StringUtils.isEmpty(chapterDto.getId())){
            this.insert(chapter);
        } else {
            this.update(chapter);
        }

    }

    /**
     * 新增
     */
    private void insert(Chapter chapter){
        chapter.setId(UuidUtil.getShortUuid());
        chapterMapper.insert(chapter);
    }

    /**
     * 更新
     */
    private void update(Chapter chapter){

        chapterMapper.updateByPrimaryKey(chapter);
    }

    public void delete(String id){

        chapterMapper.deleteByPrimaryKey(id);
    }
}
