package com.example.demo.service.impl;

import com.example.demo.eneity.Department;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Overtime;
import com.example.demo.operational.IDepartmentOper;
import com.example.demo.operational.IEmployeeOper;
import com.example.demo.operational.IOvertimeOper;
import com.example.demo.service.serviceinter.DepartmentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentImpl implements DepartmentServiceI {
    @Autowired
    private IDepartmentOper iDepartmentOper;
    @Autowired
    private IEmployeeOper iEmployeeOper;
    @Autowired
    private IOvertimeOper iOvertimeOper;

    /****
     * 获取所有部门信息
     * @return
     */
    @Override
    public List<Department> departmentList() {
        return iDepartmentOper.findAll();
    }

    /***
     * 处理显示，每个部门所有员工信息
     * @param empNum
     * @return
     */
    @Override
    public List<Employee> employeeList(Long empNum) {
        if (empNum==null)return null;
        Employee employee = new Employee();
        employee.setDepartmentNumber(empNum);
        return iEmployeeOper.findAll(Example.of(employee));
    }

    /***
     * 保存加班信息
     * @param overtime
     * @return
     */
    public boolean saveOvertimeService(Overtime overtime){
       Overtime  overtime1 = iOvertimeOper.save(overtime);
       if (null!=overtime1)return true;
        return false;
    }

    public Department getDepartment(Long deparNum){
        Department department = new Department();
        department.setDepartmentNumber(deparNum);
        return iDepartmentOper.findOne(Example.of(department));
    }
}
