package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Lea;
import com.example.demo.eneity.LeaInfo;
import com.example.demo.eneity.PageInfo;
import com.example.demo.service.impl.LeaServiceImpl;
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
     * 员工个人请假申请信息处理
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
        Employee employee = (Employee) Common.getSession(request).getAttribute("userInfo");
        Lea lea = new Lea();
        lea.setDays(days);
        lea.setStartTime(startTime);
        lea.setEndTime(endTime);
        lea.setType(type);
        lea.setReason(reason);
        lea.setDepartmentNumber(employee.getDepartmentNumber());
        lea.setEmployeeNumber(employee.getEmployeeNumber());
        lea.setStatus("未批准");
        if(leaService.saveLeaInfo(lea))return "leave_add";
        return "error";
    }

    /**
     * 个人请假明细查询
     * @param pageNo
     * @param request
     * @param model
     * @return
     */
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
        return "oneself_leave";
    }

    /***
     * 未批准请假明细控制器
     * @param model
     * @return
     */
    @RequestMapping("leave/nolist")
    public String noLeaveList(Model model){
        Lea lea = new Lea();
        lea.setStatus("未批准");
        List<Lea> leaList = leaService.leaList(lea);
        if (null!=leaList){
            List<LeaInfo> leaInfos =leaService.leaInfos(leaList);
            model.addAttribute("noleas",leaInfos);
        }
        return "leave_notlist";
    }

    /***
     * 已批准请假明细
     * @param model
     * @return
     */
    @RequestMapping("leave/yeslist")
    public String yesLeaveList(Model model){
        Lea lea = new Lea();
        lea.setStatus("已批准");
        List<Lea> leaList = leaService.leaList(lea);
        if (null!=leaList){
            List<LeaInfo> leaInfos =leaService.leaInfos(leaList);
            model.addAttribute("yesleas",leaInfos);
        }
        return "leave_yeslist";
    }

    /***
     * 医院请假记录全查
     * @param model
     * @return
     */
    @RequestMapping("leave/list")
    public String allLeaveList(Model model){
        Lea lea = new Lea();
        List<Lea> leaList = leaService.leaList(lea);
        if (null!=leaList){
            List<LeaInfo> leaInfos =leaService.leaInfos(leaList);
            model.addAttribute("alllist",leaInfos);
        }
        return "leave_list";
    }
    /***
     * 处理未批准请假记录
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("lea/donoleave")
    public String doNoLeave(@RequestParam("leaid")Long id){
        if (id==null)return "出错了";
        Lea lea = leaService.getLeaById(id);
        lea.setStatus("已批准");
        lea.setId(id);
        lea = leaService.updateLea(lea);
        if (lea==null)return "没有该条请假记录";
        return "已批准";
    }

    /***
     * 请假详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("leave/leadetail")
    public String leaveDetail(@RequestParam("leaid")Long id,Model model){
        Lea lea =leaService.getLeaById(id);
        if (null!=lea) model.addAttribute("leainfo",leaService.getLeaInfo(lea));
        return "leave_detail";
    }
}
