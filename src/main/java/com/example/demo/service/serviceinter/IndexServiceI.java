package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Attendance;

import java.text.ParseException;

public interface IndexServiceI {

    Attendance checkWork(Attendance attendance) throws ParseException;
}
