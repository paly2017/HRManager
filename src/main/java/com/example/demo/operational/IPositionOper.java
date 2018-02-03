package com.example.demo.operational;

import com.example.demo.eneity.Employee;
import com.example.demo.eneity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IPositionOper extends JpaRepository<Position,Integer> {


}
