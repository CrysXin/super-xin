package com.course.server.service;

import com.course.server.dto.PageDto;
import com.course.server.mapper.SectionMapper;
import com.course.server.dto.SectionDto;
import com.course.server.pojo.Section;
import com.course.server.pojo.SectionExample;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZHX on 2020/9/10.111111111
 */
@Service
public class SectionService {
    @Resource
    SectionMapper sectionMapper;


    /**
     * 查询
     */
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        SectionExample sectionExample = new SectionExample();

        sectionExample.setOrderByClause("sort asc");
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);

        PageInfo<Section> pageInfo = new PageInfo(sectionList);
        pageDto.setTotal(pageInfo.getTotal());

        List<SectionDto> sectionDtoList = new ArrayList<>();
        for (int i = 0; i < sectionList.size(); i++) {
            SectionDto sectionDto = new SectionDto();
            BeanUtils.copyProperties(sectionList.get(i),sectionDto);
            sectionDtoList.add(sectionDto);
        }
        pageDto.setList(sectionDtoList);

    }

    /**
     * 保存
     */
    public void save(SectionDto sectionDto){
        Section section = CopyUtil.copy(sectionDto, Section.class);
        if(StringUtils.isEmpty(sectionDto.getId())){
            this.insert(section);
        } else {
            this.update(section);
        }

    }

    /**
     * 新增
     */
    private void insert(Section section){
        Date now = new Date();
        section.setCreatedAt(now);
        section.setUpdatedAt(now);
        section.setId(UuidUtil.getShortUuid());
        sectionMapper.insert(section);
    }

    /**
     * 更新
     */
    private void update(Section section){
        section.setUpdatedAt(new Date());
        sectionMapper.updateByPrimaryKey(section);
    }

    public void delete(String id){

        sectionMapper.deleteByPrimaryKey(id);
    }
}
