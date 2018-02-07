package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Lea;
import com.example.demo.eneity.PageInfo;
import com.example.demo.service.impl.LeaServiceImpl;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
public class leaveControl {
    @Autowired
    private LeaServiceImpl leaService;
    /**
     * 跳转至请假申请页面
     * @return
     */
    @RequestMapping("addleave")
    public String sendAddLeave(){
        return "leave_add";
    }

    /***
     * 请假申请信息处理
     * @param startTime
     * @param endTime
     * @param days
     * @param type
     * @param reason
     * @param request
     * @return
     */
    @PostMapping("doleave")
    public String toLeave(@RequestParam("startdate")Date startTime,
                          @RequestParam("enddate")Date endTime,
                          @RequestParam("days")String days,
                          @RequestParam("type")String type,
                          @RequestParam("reason")String reason,
                          HttpServletRequest request){
        System.out.println(endTime);
        System.out.println(startTime);
        Employee employee = (Employee) Common.getSession(request).getAttribute("userInfo");
        Lea lea = new Lea();
        lea.setDays(days);
        lea.setStartTime(startTime);
        lea.setEndTime(endTime);
        lea.setType(type);
        lea.setReason(reason);
        lea.setDepartmentNumber(employee.getDepartmentNumber());
        lea.setEmployeeNumber(employee.getEmployeeNumber());
        if(leaService.saveLeaInfo(lea))return "leave_add";
        return "error";
    }
    @RequestMapping("leavelist")
    public String leaveList(@RequestParam("pageindex")Long pageNo,
                            HttpServletRequest request,
                            Model model){
        pageNo=pageNo<1?1:pageNo;
        Employee employee = (Employee) Common.getSession(request).getAttribute("userInfo");
        Lea lea = new Lea();
        lea.setEmployeeNumber(employee.getEmployeeNumber());
        PageInfo<Lea> pageInfo = leaService.leavesInfoByName(lea,pageNo-1);
        model.addAttribute("leaInfo",pageInfo);
        return "leave_list";
    }
}
