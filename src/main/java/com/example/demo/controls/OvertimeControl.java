package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.*;
import com.example.demo.service.impl.DepartmentImpl;
import com.example.demo.service.impl.OneSelfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

/***
 * 加班控制器
 */
@Controller
public class OvertimeControl {
    @Autowired
    private OneSelfServiceImpl oneSelfService;
    @Autowired
    private DepartmentImpl department;
    /***
     * 加班列表控制器,分页查询显示
     * @return
     */
    @RequestMapping("addworkinfo")
    public String onselfAddWorkList(Model model, @RequestParam("pageIndex") Long index){
        index = index<1?1:index;
        Page<Overtime> overtimes = oneSelfService.overtimePageService(index-1);
        PageInfo<AddWorkInfo> pageInfo =oneSelfService.addWorkInfoPage(overtimes,index);
        model.addAttribute("datas",pageInfo);
        return "oneself_overtime";
    }

    /***
     * 跳转至安排加班页面
     * @return
     */
    @RequestMapping("overtimeadd")
    public String sendAddWork(){

        return "overtime_add";
    }

    /***
     * 页面显示所有部门信息
     * @return
     */
    @ResponseBody
    @PostMapping("showalldepartment")
    public String showDepartment(){
       List<Department> departmentList = department.departmentList();
        return Common.getJsonString(departmentList);
    }

    /***
     * 部门员工信息显示控制器
     * @param empNum
     * @return
     */
    @ResponseBody
    @PostMapping("empinfo")
    public String showDepartmentEmp(@RequestParam("empNum")Long empNum){
        List<Employee> employees = department.employeeList(empNum);
        System.out.println(employees);
        return Common.getJsonString(employees);
    }

    /****
     * 保存加班信息
     * @param depNum
     * @param empNUm
     * @param date
     * @return
     */
    @PostMapping("saveovertimeinfo")
    public String saveOvertime(@RequestParam("departmentNumber")Long depNum,
                               @RequestParam("employeeNumber")Long empNUm,
                               @RequestParam("date")Date date){
       Overtime overtime = new Overtime();
       overtime.setEmployeeNumber(empNUm);
       overtime.setDepartmentNumber(depNum);
       overtime.setDay(date);
       if (department.saveOvertimeService(overtime)){
           return "overtime_add";
       }else {
           return null;
       }


    }
}
