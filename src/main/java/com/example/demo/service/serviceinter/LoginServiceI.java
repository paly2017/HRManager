package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Employee;

import javax.servlet.http.HttpServletRequest;

public interface LoginServiceI {
    /***
     * 用户登录处理方法
     * @param userName
     * @param password
     * @return
     */
    Employee doLogin(Long userName,String password);

    /***
     * 用户信息存入session中
     * @param request
     */
    void saveUserInfo(HttpServletRequest request);

}
