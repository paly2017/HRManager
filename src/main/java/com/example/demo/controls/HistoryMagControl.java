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
import java.sql.Time;
import java.text.ParseException;
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
                                     @RequestParam("notes")String notes,
                                     Model model){
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
        try {
            Date date =Common.getSqlDate();
            history.setOutTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        historyService.updateHistory(history);
        return "ok";
    }

    /***
     * 跳转至员工增加页面
     * @return
     */
    @RequestMapping("sendaddinfo")
    public String sendAddEmployee(Model model){
        Long maxEmp = historyService.maxEmpNumberInHistory();
        model.addAttribute("maxno",maxEmp);
        return "employee_add";
    }

    /***
     * 新员工信息增加
     * @return
     */
    @RequestMapping("/newhistoryinfo")
    public String addNewEmployee(@RequestParam("employeeNumber")Long empNumber,
                                 @RequestParam("name")String empName,
                                 @RequestParam("password")String password,
                                 @RequestParam("password2")String password2,
                                 @RequestParam("gender")String gender,
                                 @RequestParam("date")Date birthday,
                                 @RequestParam("telephone")String telephone,
                                 @RequestParam("email")String email,
                                 @RequestParam("address") String address,
                                 @RequestParam("education")String education,
                                 @RequestParam("departmentNumber") Long deperNo,
                                 @RequestParam("positionNumber")Long posNo,
                                 @RequestParam("notes")String notes,
                                 Model model){
        if (empName==null||!password.equals(password2)){
            model.addAttribute("maxno",empNumber);
            return "employee_add";
        }
        Employee employee =new Employee();
        History history = new History();
        employee.setEmployeeNumber(empNumber);
        history.setEmployeeNumber(empNumber);
        employee.setName(empName);
        history.setName(empName);
        employee.setPassword(password);
        employee.setGender(gender);
        history.setGender(gender);
        employee.setBirthday(birthday);
        history.setBirthday(birthday);
        employee.setTelephone(telephone);
        history.setTelephone(telephone);
        employee.setEmail(email);
        history.setEmail(email);
        employee.setAddress(address);
        history.setAddress(address);
        employee.setEducation(education);
        history.setEducation(education);
        employee.setDepartmentNumber(deperNo);
        history.setDepartmentNumber(deperNo);
        employee.setPositionNumber(posNo);
        history.setPositionNumber(posNo);
        history.setStatus("在职");
        history.setNotes(notes);
        employee.setNotes(notes);
        try {
            Date date = Common.getSqlDate();
            employee.setInTime(date);
            history.setInTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (historyService.saveNewEmpAndHis(employee,history)){
            model.addAttribute("maxno",empNumber+1);
            return "employee_add";
        }
        model.addAttribute("maxno",empNumber);
        return "employee_add";
    }

    /***
     * 全部离休员工，分页展示
     * @param index
     * @param model
     * @return
     */
    @RequestMapping("pagehistorylist")
    public String historyList(@RequestParam("pageIndex")Long index,Model model){
        PageInfo<HistoryInfo> historyInfoPageInfo = historyService.historyInfoPageInfo(index);
        model.addAttribute("his",historyInfoPageInfo);
        return "history_list";
    }

    /***
     * 离休员工详细信息控制器
     * @param empNo
     * @param model
     * @return
     */
    @RequestMapping("dohisdetail")
    public String historyDetail(@RequestParam("empNo")Long empNo,Model model){
        model.addAttribute("hisInfo",historyService.historyInfo(empNo));
        return "history_detail";
    }

    /***
     * 跳转至离休员工信息修改页面
     * @param empNo
     * @param model
     * @return
     */
    @RequestMapping("tohisupdate")
    public String historySendUpdate(@RequestParam("empNo")Long empNo,Model model){
        model.addAttribute("hisInfo",historyService.historyInfo(empNo));
        return "history_update";
    }

    /***
     * 离休员工更新控制器
     * @param empNumber
     * @param empName
     * @param gender
     * @param birthday
     * @param telephone
     * @param email
     * @param address
     * @param education
     * @param home
     * @param notes
     * @param model
     * @return
     */
    @PostMapping("dohisupdate")
    public String historyUpdate(@RequestParam("employeeNumber")Long empNumber,
                                @RequestParam("name")String empName,
                                @RequestParam("gender")String gender,
                                @RequestParam("date")Date birthday,
                                @RequestParam("telephone")String telephone,
                                @RequestParam("email")String email,
                                @RequestParam("address") String address,
                                @RequestParam("education")String education,
                                @RequestParam("home")String home,
                                @RequestParam("notes")String notes,
                                Model model){
        History history = historyService.getHistory(empNumber);
        history.setHome(home);
        history.setNotes(notes);
        history.setEducation(education);
        history.setAddress(address);
        history.setEmail(email);
        history.setBirthday(birthday);
        history.setTelephone(telephone);
        history.setGender(gender);
        history.setName(empName);
        history = historyService.updateHistory(history);
        model.addAttribute("hisInfo",historyService.historyInfo(history.getEmployeeNumber()));
        return "history_update";
    }
}
