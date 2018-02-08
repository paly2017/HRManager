package com.example.demo.operational;

import com.example.demo.eneity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHistoryOper extends JpaRepository<History,Long> {
    @Query("select max(e.employeeNumber) from History e")
    int getMaxNumByEmployeeNumber();
}
