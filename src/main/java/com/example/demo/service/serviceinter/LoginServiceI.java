package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Employee;

public interface LoginServiceI {
    /***
     * 用户登录处理方法
     * @param userName
     * @param password
     * @return
     */
    boolean doLogin(Long userName,String password);

}
