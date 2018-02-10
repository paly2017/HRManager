package com.example.demo.controls;

import com.example.demo.Uitl.Common;
import com.example.demo.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/*****
 * 控制登录页面跳转
 */
@Controller
public class SendLoginControl {
    @Autowired
    private LoginService loginService;

    /****
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("login")
    public String sendLogin(){
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
        if (loginService.doLogin(userName,password)){
            loginService.saveUserInfo(request);
            return "index";
        }else {
            return "login";
        }
    }
    @RequestMapping("wolcome")
    public String index(){
        return "wolcome";
    }
}
