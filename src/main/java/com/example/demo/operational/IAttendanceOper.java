package com.example.demo.operational;

import com.example.demo.eneity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttendanceOper extends JpaRepository<Attendance,Long> {
}
