package com.example.demo.service.impl;

import com.example.demo.eneity.*;
import com.example.demo.operational.IDepartmentOper;
import com.example.demo.operational.IEmployeeOper;
import com.example.demo.operational.IHistoryOper;
import com.example.demo.operational.IPositionOper;
import com.example.demo.service.serviceinter.HistoryServiceI;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class HistoryServiceImpl implements HistoryServiceI {
    @Autowired
    private IHistoryOper iHistoryOper;
    @Autowired
    private IPositionOper iPositionOper;
    @Autowired
    private IDepartmentOper iDepartmentOper;
    @Autowired
    private IEmployeeOper iEmployeeOper;

    /***
     * 在职员工分页显示
     * @param index
     * @return
     */
    @Override
    public PageInfo<HistoryInfo> employeeList(Long index) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest((int) (index-1),10,sort);
        History historyl = new History();
        historyl.setStatus("在职");
        Page<History> histories = iHistoryOper.findAll(Example.of(historyl),pageable);
        Iterator<History> it = histories.iterator();
        List<HistoryInfo> historyInfos = new ArrayList<>();
        while (it.hasNext()){
            History history = it.next();
            Position position = iPositionOper.findByPositionNumber(history.getPositionNumber());
            Department department1 = new Department();
            department1.setDepartmentNumber(history.getDepartmentNumber());
            Department department =iDepartmentOper.findOne(Example.of(department1));
            HistoryInfo historyInfo = new HistoryInfo(history,position,department);
            historyInfos.add(historyInfo);
        }
        PageInfo<HistoryInfo> pageInfo =new PageInfo<HistoryInfo>(10L,index,histories.getTotalElements());
        pageInfo.setList(historyInfos);
        return pageInfo;
    }

    /***
     * 根据emp编号查询一个History
     * @param empNo
     * @return
     */
    public History getHistory(Long empNo){
        History history =new History();
        history.setEmployeeNumber(empNo);
        return iHistoryOper.findOne(Example.of(history));
    }
    /***
     * 查询员工信息
     * @param pageInfo
     * @param empNo
     * @return
     */
    @Override
    public HistoryInfo employeeInfo(PageInfo<HistoryInfo> pageInfo, Long empNo) {
        Optional.of(pageInfo);
        List<HistoryInfo> infoList = pageInfo.getList();
        if (infoList==null)return null;
        for (HistoryInfo historyInfo:infoList){
            if (historyInfo.gethistory().getEmployeeNumber().equals(empNo)){
                Employee ee = new Employee();
                ee.setEmployeeNumber(empNo);
                Employee employee = iEmployeeOper.findOne(Example.of(ee));
                historyInfo.setEmployee(employee);
                return historyInfo;
            }
        }
        return null;
    }

    /***
     * 员工删除
     * @param employee
     * @return
     */
    public void deleteEmployee(Employee employee){
        iEmployeeOper.delete(employee);
    }

    /***
     * 更新员工信息
     * @param employee
     * @return
     */
    public Employee updateEmployee(Employee employee){
        return iEmployeeOper.saveAndFlush(employee);
    }

    public History updateHistory(History history){
        return  iHistoryOper.saveAndFlush(history);
    }

    /***
     * 跟剧empNo 查询Emp
     * @param employee
     * @return
     */
    public Employee getEmployee(Long employee){
        Employee employee1 = new Employee();
        employee1.setEmployeeNumber(employee);
        return iEmployeeOper.findOne(Example.of(employee1));
    }
}
