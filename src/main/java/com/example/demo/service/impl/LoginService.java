package com.example.demo.service.impl;

import com.example.demo.Uitl.Common;
import com.example.demo.eneity.Employee;
import com.example.demo.operational.IEmployeeOper;
import com.example.demo.service.serviceinter.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService implements LoginServiceI{
    @Autowired
    private IEmployeeOper iEmployeeOper;

    private Employee employee;

    /****
     * 用户登录实现方法
     * @param userName
     * @param password
     * @return
     */
    @Override
    public boolean doLogin(Long userName, String password) {
        Employee employee = iEmployeeOper.
                            findByEmployeeNumberAndPassword(userName, password);
        System.out.println(employee);
        if (null!=employee){
           this.employee=employee;
            return true;
        }
        return false;
    }

    /***
     * 将登录用户信息存入session中
     * @param request
     */
    @Override
    public void saveUserInfo(HttpServletRequest request) {
        if (null!=employee){
            Common.getSession(request).setAttribute("userInfo",employee);
        }
    }


}
