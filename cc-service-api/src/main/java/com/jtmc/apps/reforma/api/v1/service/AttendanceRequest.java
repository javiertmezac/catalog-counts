package com.jtmc.apps.reforma.api.v1.service;

import java.util.List;

public class AttendanceRequest {

    private List<Attendance> attendanceList;

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }
}
