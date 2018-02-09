package com.example.demo.operational;

import com.example.demo.eneity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentOper extends JpaRepository<Department,Long> {

    Department findByDepartmentNumber(Long number);
}
