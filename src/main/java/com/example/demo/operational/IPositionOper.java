package com.example.demo.operational;

import com.example.demo.eneity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionOper extends JpaRepository<Position,Integer> {
}
