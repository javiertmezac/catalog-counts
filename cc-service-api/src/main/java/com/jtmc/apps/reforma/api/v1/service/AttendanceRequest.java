package com.jtmc.apps.reforma.api.v1.service;

import java.util.List;

public class AttendanceRequest {

    private List<AttendanceResponse> attendanceList;

    public List<AttendanceResponse> getAttendanceResponseList() {
        return attendanceList;
    }

    public void setAttendanceList(List<AttendanceResponse> attendanceResponseList) {
        this.attendanceList = attendanceResponseList;
    }
}
