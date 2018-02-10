package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Department;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Overtime;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentServiceI {

    List<Department> departmentList();

    List<Employee> employeeList(Long empNum);

    boolean saveOvertimeService(Overtime overtime);

    Page<Department> departmentPage(Long index);

    String deleteById(Long id);

    Department getDepartment(Department department);

    Department saveAanUpdataDepartment(Department department);

    int MaxDepartmentNumber();
}
