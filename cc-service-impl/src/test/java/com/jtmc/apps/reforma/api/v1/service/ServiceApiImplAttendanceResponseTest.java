package com.jtmc.apps.reforma.api.v1.service;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.impl.service.ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

class ServiceApiImplAttendanceResponseTest {

    @InjectMocks
    private ServiceApiImpl serviceApi;

    @Mock
    private ServiceImpl serviceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAttendanceList_shouldCall_serviceImpl_attendanceList() {
        serviceApi.getAttendanceList(0);
        verify(serviceImpl).getAttendanceListByServiceId(anyInt());
    }

    @Test
    void saveAttendanceList() {
    }

}