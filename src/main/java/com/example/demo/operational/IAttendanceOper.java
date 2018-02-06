package com.example.demo.operational;

import com.example.demo.eneity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface IAttendanceOper extends JpaRepository<Attendance,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Attendance AS c set c.endTime=?1 ,c.endType=?2 where c.id=?3")
    int updataEndTimeAndEndTypeById(Time time,String endType,Long id);


    List<Attendance> findAllByEmployeeNumber(Long empNumber);
}
