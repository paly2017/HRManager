package com.example.demo.eneity;

public class HistoryInfo {
    private History history;
    private Position position;
    private Department department;
    private Employee employee;

    public HistoryInfo() {
    }

    public HistoryInfo(History history, Position position, Department department) {
        this.history = history;
        this.position = position;
        this.department = department;
    }

    public History gethistory() {
        return history;
    }

    public void sethistory(History history) {
        this.history = history;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
