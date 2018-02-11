package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.Employee;
import com.example.demo.service.impl.LoginService;
import com.example.demo.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

/*****
 * 控制登录页面跳转
 */
@Controller
public class SendLoginControl {
    @Autowired
    private LoginService loginService;
    @Autowired
    private PositionServiceImpl positionService;

    /****
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("login")
    public String sendLogin(HttpServletRequest request){
        HttpSession session = Common.getSession(request);
        Employee employee = (Employee) session.getAttribute("userInfo");
        if (employee!=null){
            session.invalidate();
        }
        return "login";
    }

    /***
     * 用户登录处理方法
     * @param userName
     * @param password
     * @param
     * @return
     */
   @PostMapping("dologin")
    public String doLogin(@RequestParam("employeeNumber")Long userName,
                          @RequestParam("password")String password,
                          HttpServletRequest request) {
       if (null==userName||null==password)return "login";
       Employee employee =loginService.doLogin(userName,password);
        if (null!=employee){
            loginService.saveUserInfo(request);
            String level = positionService.getOnePosition(employee.getPositionNumber()).getLevel();
            if ("人事部主任".equals(level)){
                return "index";
            }else if ("人事部员工".equals(level)){
                return "index1";
            }else if ("部门主任".equals(level)){
                return "index2";
            }else {
                return "index3";
            }

        }else {
            return "login";
        }
    }
    @RequestMapping("wolcome")
    public String index(){
        return "wolcome";
    }
}
