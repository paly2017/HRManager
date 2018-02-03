package com.example.demo.operational;

import com.example.demo.eneity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IEmployeeOper extends JpaRepository<Employee,Integer> {
    /***
     * 根据员工编号及密码查询用户信息
     * @param name
     * @param pass
     * @return
     */
    Employee findByEmployeeNumberAndPassword(@Param("name") Long name, @Param("pass") String pass);

}
