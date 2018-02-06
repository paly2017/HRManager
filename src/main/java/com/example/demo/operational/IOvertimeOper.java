package com.example.demo.operational;

import com.example.demo.eneity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IOvertimeOper extends JpaRepository<Overtime,Long> {

    Long countByEmployeeNumber(Long empNum);

}
