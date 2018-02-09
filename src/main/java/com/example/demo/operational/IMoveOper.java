package com.example.demo.operational;

import com.example.demo.eneity.Move;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMoveOper extends JpaRepository<Move,Long> {
}
