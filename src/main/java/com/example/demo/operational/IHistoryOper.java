package com.example.demo.operational;

import com.example.demo.eneity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryOper extends JpaRepository<History,Long> {

}
