package com.shixin.mapper;

import com.shixin.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 是新
 * @create 2023-11-27 11:37
 * @Description :
 */

public interface ScheduleMapper {
    @Select("select * from schedule")
    public List<Schedule> selectAll();
}
