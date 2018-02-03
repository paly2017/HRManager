package com.example.demo.service.impl;

import com.example.demo.eneity.Employee;
import com.example.demo.operational.IEmployeeOper;
import com.example.demo.service.serviceinter.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceI{
    @Autowired
    private IEmployeeOper iEmployeeOper;

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

        return false;
    }


}
