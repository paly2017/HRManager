package com.example.demo.service.serviceinter;


import com.example.demo.eneity.Employee;
import com.example.demo.eneity.History;
import com.example.demo.eneity.HistoryInfo;
import com.example.demo.eneity.PageInfo;

public interface HistoryServiceI {

    PageInfo<HistoryInfo> employeeList(Long index);

    HistoryInfo employeeInfo(PageInfo<HistoryInfo> pageInfo,Long empNo);

    void deleteEmployee(Employee employee);

    History getHistory(Long empNo);

    Employee updateEmployee(Employee employee);

    History updateHistory(History history);

    Employee getEmployee(Long employee);
}
