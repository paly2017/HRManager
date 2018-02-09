package com.example.demo.service.serviceinter;


import com.example.demo.eneity.AddWorkInfo;
import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Overtime;
import com.example.demo.eneity.PageInfo;
import org.springframework.data.domain.Page;


import javax.servlet.http.HttpServletRequest;


public interface OneSelfService {

    boolean updateEmployee(Employee employee);

    void updataSession(HttpServletRequest request,Employee employee);

    void oneSelfAttenService(HttpServletRequest request);

    Page<Overtime> overtimePageService(Long index,Employee employee);

    Page<Overtime> overtimePageService(Long index);

    PageInfo<AddWorkInfo> addWorkInfoPage(Page page, Long index);

    AddWorkInfo OverTimeInfo(Long id);

    Overtime updataOvertime(Overtime overtime);

    void deleteOvertim(Long overId);
}
