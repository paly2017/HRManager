package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.*;
import com.example.demo.service.impl.DepartmentImpl;
import com.example.demo.service.impl.HistoryServiceImpl;
import com.example.demo.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class HistoryMagControl {
    @Autowired
    private HistoryServiceImpl historyService;
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private DepartmentImpl department;

    /****
     * 员工信息分页展示
     * @param index
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("emplist")
    public String sendEmpioyeeList(@RequestParam("pageindex")Long index,
                                   Model model,
                                   HttpServletRequest request){
        index=index<=0?1:index;
        PageInfo<HistoryInfo> pageInfo = historyService.employeeList(index);
        Common.getSession(request).setAttribute("empinfo",pageInfo);
        model.addAttribute("empinfo",pageInfo);
        return "employee_list";
    }

    /***
     * 员工详细信息查看控制器
     * @param empNo
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("empdetial")
    public String empDetial(Long empNo,HttpServletRequest request,Model model){
        //非空
        Optional.of(empNo);
        PageInfo<HistoryInfo> historyInfoPageInfo=
                (PageInfo<HistoryInfo>) Common.getSession(request).getAttribute("empinfo");
        HistoryInfo history = historyService.employeeInfo(historyInfoPageInfo,empNo);
        if (history!=null){
            model.addAttribute("emp",history);
            return "employee_detail";
        }
        return "employee_list";
    }

    /***
     * 跳转至员工信息修改页面控制器
     * @param empNo
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("sendupdateemp")
    public String empUpdate(Long empNo,HttpServletRequest request,Model model){
        Optional.of(empNo);
        PageInfo<HistoryInfo> historyInfoPageInfo=
                (PageInfo<HistoryInfo>) Common.getSession(request).getAttribute("empinfo");
        HistoryInfo history = historyService.employeeInfo(historyInfoPageInfo,empNo);
        if (history!=null){
            model.addAttribute("emp",history);
            return "employee_update";
        }
        return "employee_list";
    }

    /***
     * 职位信息显示控制器
     * @return
     */
    @ResponseBody
    @PostMapping("toposttion")
    public String positionInfo(){
        List<Position> positionList = positionService.positionList();
        return Common.getJsonString(positionList);
    }

    /***
     * 员工信息修改
     * @param empNumber
     * @param empName
     * @param password
     * @param gender
     * @param birthday
     * @param telephone
     * @param email
     * @param address
     * @param education
     * @param deperNo
     * @param posNo
     * @param status
     * @param notes
     * @return
     */
    @PostMapping("updateemp")
    public String updateEmployeeInfo(@RequestParam("employeeNumber")Long empNumber,
                                     @RequestParam("name")String empName,
                                     @RequestParam("password")String password,
                                     @RequestParam("gender")String gender,
                                     @RequestParam("date")Date birthday,
                                     @RequestParam("telephone")String telephone,
                                     @RequestParam("email")String email,
                                     @RequestParam("address") String address,
                                     @RequestParam("education")String education,
                                     @RequestParam("departmentNumber") Long deperNo,
                                     @RequestParam("positionNumber")Long posNo,
                                     @RequestParam("status")String status,
                                     @RequestParam("notes")String notes,Model model){
        Employee employee = historyService.getEmployee(empNumber);
        History history = historyService.getHistory(empNumber);
        if (!"".equals(empNumber)){
            employee.setEmployeeNumber(empNumber);
            history.setEmployeeNumber(empNumber);
        }
        if (!"".equals(empName)){
            employee.setName(empName);
            history.setName(empName);
        }
        if (!"".equals(password)){
            employee.setPassword(password);
        }
        if (!"".equals(gender)){
            employee.setGender(gender);
            history.setGender(gender);
        }
        if (null!=birthday){
            employee.setBirthday(birthday);
            history.setBirthday(birthday);
        }
        if (!"".equals(telephone)){
            employee.setTelephone(telephone);
            history.setTelephone(telephone);
        }
        if (!"".equals(email)){
            employee.setEmail(email);
            history.setEmail(email);
        }
        if (!"".equals(address)){
            employee.setAddress(address);
            history.setAddress(address);
        }
        if (!"".equals(education)){
            employee.setEducation(education);
            history.setEducation(education);
        }
        if (null!=deperNo){
            employee.setDepartmentNumber(deperNo);
            history.setDepartmentNumber(deperNo);
        }
        if (null!=posNo){
            employee.setPositionNumber(posNo);
            history.setPositionNumber(posNo);
        }
        if (!"".equals(notes)){
            employee.setNotes(notes);
            history.setNotes(notes);
        }
        history.setStatus(status);
        Employee employee1=null;
        if ("退休".equals(status)||"离职".equals(status)){
            historyService.deleteEmployee(employee);
        }else {
          employee1 = historyService.updateEmployee(employee);
        }
        History history1 =  historyService.updateHistory(history);
        Department depar = department.getDepartment(employee1.getDepartmentNumber());
        Position position = positionService.getOnePosition(employee1.getPositionNumber());
        HistoryInfo historyInfo = new HistoryInfo();
        historyInfo.setEmployee(employee1);
        historyInfo.sethistory(history1);
        historyInfo.setPosition(position);
        historyInfo.setDepartment(depar);
        model.addAttribute("emp",historyInfo);
        return "employee_update";
    }

    /***
     * 删除
     * @param empNo
     * @return
     */
    @ResponseBody
    @PostMapping("deleteempl")
    public String deleteEmployee(@RequestParam("empnumber")Long empNo){
        if (empNo==null)return "no";
        Employee employee = historyService.getEmployee(empNo);
        historyService.deleteEmployee(employee);
        History history = historyService.getHistory(empNo);
        history.setStatus("离职");
        historyService.updateHistory(history);
        return "ok";
    }
}
