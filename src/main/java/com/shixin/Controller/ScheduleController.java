package com.shixin.Controller;

import com.shixin.mapper.ScheduleMapper;
import com.shixin.pojo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 是新
 * @create 2023-11-26 22:20
 * @Description :
 */
@Controller
@ResponseBody
public class ScheduleController {

    @Autowired
    ScheduleMapper scheduleMapper;

    @GetMapping("/test")
    public List<Schedule> test(){
        return scheduleMapper.selectAll();
    }
}
