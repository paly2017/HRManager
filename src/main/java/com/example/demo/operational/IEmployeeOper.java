package com.example.demo.operational;

import com.example.demo.eneity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeOper extends JpaRepository<Employee,Integer> {
    Employee findByNameAndPassword(String name,String pass);

}
