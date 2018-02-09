package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.Uitl.Confing;
import com.example.demo.eneity.Attendance;
import com.example.demo.service.impl.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;


@RestController
public class IndexControl {
    @Autowired
    private IndexServiceImpl indexService;
    @RequestMapping("upwork")
    public String upWork(@RequestParam("employeeNumber") Long id){
        if (null==id){
            return "no";
        }
        Attendance attendance = new Attendance();
        attendance.setEmployeeNumber(id);
        Attendance attendance1=null;
        try {
            attendance1 = indexService.checkWork(attendance);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (null==attendance1)return null;
        return Common.getJsonString(attendance1);
    }
    @PostMapping("downwork")
    public String downWork(@RequestParam("attendanceid")Long id) {
        if (null==id)return "no";
        boolean boo=false;
        try {
         boo = indexService.downWork(id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (boo){
            return "ok";
        }
        return "no";
    }
}
