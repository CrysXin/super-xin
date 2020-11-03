package com.course.server.mapper.my;

import org.apache.ibatis.annotations.Param;

public interface MyCourseMapper {
    void updateTime(@Param("courseId") String  courseId);
}
