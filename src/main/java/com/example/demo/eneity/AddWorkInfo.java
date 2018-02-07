package com.example.demo.eneity;

public class AddWorkInfo {
    private Employee employee;
    private Department department;
    private Overtime overtime;

    public AddWorkInfo() {
    }

    public AddWorkInfo(Department department, Overtime overtime) {
        this.department = department;
        this.overtime = overtime;
    }

    public AddWorkInfo(Employee employee, Department department, Overtime overtime) {
        this.employee = employee;
        this.department = department;
        this.overtime = overtime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Overtime getOvertime() {
        return overtime;
    }

    public void setOvertime(Overtime overtime) {
        this.overtime = overtime;
    }
}
