package com.example.demo.eneity;

public class AttendanceInfo {
    private Attendance attendance;
    private History history;

    public AttendanceInfo() {
    }

    public AttendanceInfo(Attendance attendance, History history) {
        this.attendance = attendance;
        this.history = history;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
