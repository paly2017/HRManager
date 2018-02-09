package com.example.demo.service.impl;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.*;
import com.example.demo.operational.*;
import com.example.demo.service.serviceinter.OneSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OneSelfServiceImpl implements OneSelfService {
    @Autowired
    private IEmployeeOper iEmployeeOper;
    @Autowired
    private IAttendanceOper iAttendanceOper;
    @Autowired
    private IOvertimeOper iOvertimeOper;
    @Autowired
    private IPositionOper iPositionOper;
    @Autowired
    private IDepartmentOper iDepartmentOper;

    /***
     * 个人信息修改
     * @param employee
     * @return
     */
    @Override
    public boolean updateEmployee(Employee employee) {
        boolean flag=false;
      int  count =  iEmployeeOper.updataEmployeeById(employee.getName(),employee.getGender(),
                employee.getBirthday(),employee.getTelephone(),employee.getEmail(),
                employee.getAddress(),employee.getEducation(),employee.getPassword(),
                employee.getNotes(),employee.getId());
      if (count>0){
          flag= true;
      }
        return flag;
    }

    /***
     * 更新session中的用户信息
     * @param request
     */
    @Override
    public void updataSession(HttpServletRequest request,Employee employee) {
        HttpSession session = Common.getSession(request);
        session.removeAttribute("userInfo");
        session.setAttribute("userInfo",employee);

    }

    /***
     * 个人签到记录查询业务处理
     * @param request
     */
    @Override
    public void oneSelfAttenService(HttpServletRequest request) {
        HttpSession session =Common.getSession(request);
        Employee employee = (Employee)session.getAttribute("userInfo");
        List<Attendance> attendanceList=null;
        if (employee!=null){
            attendanceList =  iAttendanceOper.findAllByEmployeeNumber(employee.getEmployeeNumber());
        }
        if (attendanceList!=null){
            session.setAttribute("attendancelist",attendanceList);
        }
    }

    /***
     * 加班信息分页查询
     * @param index
     * @return
     */
    public Page<Overtime> overtimePageService(Long index,Employee employee){
        if (employee==null)return null;
        Sort sort = new Sort(Sort.Direction.DESC,"day");
        Pageable pageable = new PageRequest(Math.toIntExact(index),10,sort);
        Overtime overtime = new Overtime();
        overtime.setEmployeeNumber(employee.getEmployeeNumber());
        Page<Overtime> overtimePage = iOvertimeOper.findAll(Example.of(overtime),pageable);
        return overtimePage;
    }

    /****
     * 加班分页页面显示信息
     * @param page
     * @param
     * @return
     */
    public PageInfo<AddWorkInfo> addWorkInfoPage(Page page,Long index){
        Iterator<Overtime> iterator = (Iterator<Overtime>) page.iterator();
        PageInfo<AddWorkInfo> infoPageInfo =
                new PageInfo<AddWorkInfo>(10L, index, page.getTotalElements());
        List<AddWorkInfo> addWorkInfos = new ArrayList<>();
        while (iterator.hasNext()){
            Overtime overtime = iterator.next();
            Department department = new Department();
            department.setDepartmentNumber(overtime.getDepartmentNumber());
            Department department1 = iDepartmentOper.findOne(Example.of(department));
            Employee employee = new Employee();
            employee.setEmployeeNumber(overtime.getEmployeeNumber());
            Employee employee1 = iEmployeeOper.findOne(Example.of(employee));
            AddWorkInfo addWorkInfo = new AddWorkInfo(employee1,department1,overtime);
            addWorkInfos.add(addWorkInfo);
        }
        infoPageInfo.setList(addWorkInfos);
        return infoPageInfo;
    }



}
