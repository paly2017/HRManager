package com.example.demo.service.impl;

import com.example.demo.eneity.Attendance;
import com.example.demo.eneity.AttendanceInfo;
import com.example.demo.eneity.History;
import com.example.demo.operational.IAttendanceOper;
import com.example.demo.operational.IHistoryOper;
import com.example.demo.service.serviceinter.AttendanceServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AttendanceServiceImpl implements AttendanceServiceI {
    @Autowired
    private IAttendanceOper iAttendanceOper;
    @Autowired
    private IHistoryOper iHistoryOper;
  public List<AttendanceInfo> attendanceList(){
      Sort sort = new Sort(Sort.Direction.DESC,"day");
      List<Attendance> attendanceList = iAttendanceOper.findAll(sort);
      if (attendanceList==null)return null;
      List<AttendanceInfo> attendanceInfos = new ArrayList<>();
      for (Attendance attendance : attendanceList){
          History history =iHistoryOper.findByEmployeeNumber(attendance.getEmployeeNumber());
          AttendanceInfo attendanceInfo = new AttendanceInfo(attendance,history);
          attendanceInfos.add(attendanceInfo);
      }
       return attendanceInfos;
   }
}
