package com.example.demo.service.impl;

import com.example.demo.Uitl.Common;
import com.example.demo.Uitl.Confing;
import com.example.demo.eneity.Attendance;
import com.example.demo.operational.IAttendanceOper;
import com.example.demo.service.serviceinter.IndexServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class IndexServiceImpl implements IndexServiceI {
    @Autowired
    private  IAttendanceOper iAttendanceOper;
    @Override
    public Attendance checkWork(Attendance attendance) throws ParseException {
        if (null==attendance)return null;
        attendance.setDay(Common.getSqlDate());
        attendance.setStartTime(Common.getSqlTime());
        if (Common.getSqlTime().before(Common.getCheckTime("8:30:00"))){
            attendance.setStartType(Confing.SYS_WORK_TYPE_YES.getKey());
        }else {
            attendance.setStartType(Confing.SYS_WORK_TYPE_NO.getKey());
        }
        if (Common.getSqlTime().before(Common.getCheckTime("12:00:00"))){
            attendance.setTimeType(Confing.SYS_AM_TIME.getKey());
        }else {
            attendance.setTimeType(Confing.SYS_PM_TIME.getKey());
        }
        attendance.setWorkType(Confing.SYS_WORK_TYPE_COME.getKey());
        return iAttendanceOper.save(attendance);
    }
}
