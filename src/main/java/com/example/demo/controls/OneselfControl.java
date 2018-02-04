package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Position;
import com.example.demo.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OneselfControl {
    @Autowired
    private PositionServiceImpl positionService;
    @RequestMapping("oneselfdetail")
    public String oneSelfDetail(HttpServletRequest request, Model model){
        Employee employee = (Employee) Common.getSession(request).getAttribute("userInfo");
        if (null!=employee&&null!=Long.valueOf(employee.getPositionNumber())){
            Position position = positionService.getOnePosition(employee.getPositionNumber());
            model.addAttribute("position",position);
        }
        return "oneself_detail";
    }
}
