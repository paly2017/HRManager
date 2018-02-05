package com.example.demo.operational;

import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IPositionOper extends JpaRepository<Position,Integer> {
    /***
     * 根据部门编号，查询部门信息
     * @param number
     * @return
     */
    Position findByPositionNumber(Long number);
}
