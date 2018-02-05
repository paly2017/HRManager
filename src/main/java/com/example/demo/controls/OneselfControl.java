package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Position;
import com.example.demo.service.impl.OneSelfServiceImpl;
import com.example.demo.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/***
 * 个人资料信息处理控制器
 */
@Controller
public class OneselfControl {
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private OneSelfServiceImpl oneSelfService;

    /****
     * 个人信息展示
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("oneselfdetail")
    public String oneSelfDetail(HttpServletRequest request, Model model){
        Employee employee = (Employee) Common.getSession(request).getAttribute("userInfo");
        if (null!=employee&&null!=Long.valueOf(employee.getPositionNumber())){
            Position position = positionService.getOnePosition(employee.getPositionNumber());
            model.addAttribute("position",position);
        }
        return "oneself_detail";
    }

    /***
     * 跳转至个人信息修改页面
     * @return
     */
    @RequestMapping("sendupdataoneself")
    public String sendUpdataOneself(){
        return "oneself_update";
    }

    /***
     * 用户资料修改
     * @param employeeNumber
     * @param name
     * @param password
     * @param gender
     * @param birthday
     * @param telephone
     * @param email
     * @param address
     * @param education
     * @param notes
     * @return
     */
    @PostMapping("updataoneself")
    public String upDataOneself(@RequestParam("employeeNumber")Long employeeNumber,
                                @RequestParam("name")String name,
                                @RequestParam("password")String password,
                                @RequestParam("gender")String gender,
                                @RequestParam("date")Date birthday,
                                @RequestParam("telephone")String telephone,
                                @RequestParam("email") String email,
                                @RequestParam("address")String address,
                                @RequestParam("education")String education,
                                @RequestParam("notes")String notes,
                                HttpServletRequest request){
        Employee employee = (Employee) Common.getSession(request).getAttribute("userInfo");
        if ("".equals(name)||"".equals(password)||"".equals(gender)||null==birthday
                ||"".equals(email)||"".equals(address)|| "".equals(education)||"".equals(telephone)){
            return "修改失败，字段不能为空";
        }
        employee.setName(name);
        employee.setPassword(password);
        employee.setAddress(address);
        employee.setBirthday(birthday);
        employee.setEducation(education);
        employee.setEmail(email);
        employee.setTelephone(telephone);
        if (null!=notes){
            employee.setNotes(notes);
        }
        if (oneSelfService.updateEmployee(employee))oneSelfService.updataSession(request,employee);
        return "oneself_update";
    }
}
