package com.example.demo.operational;

import com.example.demo.eneity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDepartmentOper extends JpaRepository<Department,Long> {

    Department findByDepartmentNumber(Long number);
    @Query("select max(d.departmentNumber) from Department d")
    int getMaxNumberByDepartmentNumber();
}
