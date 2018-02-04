package com.example.demo.Uitl;

public enum Confing {
    SYS_AM_TIME("上午"),
    SYS_PM_TIME("下午"),
    SYS_ADD_TIME("加班"),
    SYS_START_TIME("上班"),
    SYS_END_TIME("下班"),
    SYS_LEAVE_EARLY("早退"),
    SYS_WORK_TYPE_COME("上班"),
    SYS_WORK_TYPE_HOME("请假"),
    SYS_WORK_TYPE_YES("正常"),
    SYS_WORK_TYPE_NO("迟到");


    private String key;

    private Confing(String key){
        this.key=key;
    }

    public String getKey() {
        return key;
    }
}
