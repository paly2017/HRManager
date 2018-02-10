package com.example.demo.service.impl;

import com.example.demo.eneity.Department;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.History;
import com.example.demo.eneity.Overtime;
import com.example.demo.operational.IDepartmentOper;
import com.example.demo.operational.IEmployeeOper;
import com.example.demo.operational.IHistoryOper;
import com.example.demo.operational.IOvertimeOper;
import com.example.demo.service.serviceinter.DepartmentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
    @Autowired
    private IHistoryOper iHistoryOper;


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

    /***
     * 部门信息分页查询
     * @param index
     * @return
     */
    @Override
    public Page<Department> departmentPage(Long index) {
        index=index<1||index==null?1:index;
        Pageable pageable = new PageRequest((int) (index-1),10,new Sort(Sort.Direction.DESC,"id"));
        return iDepartmentOper.findAll(pageable);
    }

    public Department getDepartment(Long deparNum){
        Department department = new Department();
        department.setDepartmentNumber(deparNum);
        return iDepartmentOper.findOne(Example.of(department));
    }

    /***
     * 删除部门
     * @param id
     * @return
     */
    public String deleteById(Long id){
        Department department = iDepartmentOper.findOne(id);
        History employee =new History();
        employee.setDepartmentNumber(department.getDepartmentNumber());
        List<History> employees = iHistoryOper.findAll(Example.of(employee));
        if (employees==null||employees.size()==0){
            iDepartmentOper.delete(id);
            return "删除成功";
        }
        return "不可以删除";
    }

    /***
     * 任意条件查询Department
     * @param department
     * @return
     */
    public Department getDepartment(Department department){
        return iDepartmentOper.findOne(Example.of(department));
    }

    /**
     * 保存更新Department
     * @param department
     * @return
     */
    public Department saveAanUpdataDepartment(Department department){
        return iDepartmentOper.saveAndFlush(department);
    }

    /***
     * 查询最大部门编号
     * @return
     */
    public int MaxDepartmentNumber(){
        return iDepartmentOper.getMaxNumberByDepartmentNumber();
    }
}
