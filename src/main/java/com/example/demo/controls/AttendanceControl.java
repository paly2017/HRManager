package com.example.demo.controls;

import com.example.demo.eneity.AttendanceInfo;
import com.example.demo.service.impl.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AttendanceControl {
    @Autowired
    private AttendanceServiceImpl attendanceService;
    @RequestMapping("attendance/list")
    public String attendanceList(Model model){
        List<AttendanceInfo> attendanceInfos = attendanceService.attendanceList();
        System.out.println(attendanceInfos);
        model.addAttribute("attendances",attendanceInfos);
        return "attendance_list";
    }
}
