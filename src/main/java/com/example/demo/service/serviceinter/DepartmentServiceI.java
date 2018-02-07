package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Department;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Overtime;

import java.util.List;

public interface DepartmentServiceI {

    List<Department> departmentList();

    List<Employee> employeeList(Long empNum);

    boolean saveOvertimeService(Overtime overtime);
}
