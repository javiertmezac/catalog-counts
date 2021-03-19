package com.jtmc.apps.reforma.api.v1.service;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;

import javax.ws.rs.core.Response;
import java.util.List;

public class ServiceApiImpl implements ServiceApi{

    @Inject
    private AttendanceMapper attendanceMapper;

    @Override
    public Response createService(ServiceRequest request) {
        return null;
    }

    @Override
    public AttendanceResponse getAttendanceList(int idService) {
        /*
        1. get all attendance where idService = #idService
         */
        List<Persona> personas = attendanceMapper.selectAttendanceByIdService();
        return null;
    }

    @Override
    public Response saveAttendanceList(int idService, AttendanceRequest request) {
        return null;
    }
}
