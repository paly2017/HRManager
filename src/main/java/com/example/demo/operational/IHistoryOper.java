package com.example.demo.operational;

import com.example.demo.eneity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHistoryOper extends JpaRepository<History,Long> {
    @Query("select max(e.employeeNumber) from History e")
    int getMaxNumByEmployeeNumber();

    Page<History> findAllByStatusOrStatus(String status1, String status2, Pageable pageable);
}
