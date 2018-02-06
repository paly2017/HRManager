package com.example.demo.operational;

import com.example.demo.eneity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

public interface IEmployeeOper extends JpaRepository<Employee,Integer> {
    /***
     * 根据员工编号及密码查询用户信息
     * @param name
     * @param pass
     * @return
     */
    Employee findByEmployeeNumberAndPassword(@Param("name") Long name, @Param("pass") String pass);
    @Transactional
    @Modifying
    @Query("update Employee as c set c.name=?1,c.gender=?2,c.birthday=?3,c.telephone=?4,c.email=?5," +
            "c.address=?6,c.education=?7,c.password=?8,c.notes=?9 where c.id=?10")
    int updataEmployeeById(String name, String gender, Date birthday,
                           String telephone,String email,String address,
                           String education,String password,String notes,Long id);

}
