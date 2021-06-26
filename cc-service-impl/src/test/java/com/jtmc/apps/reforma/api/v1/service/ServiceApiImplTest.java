package com.jtmc.apps.reforma.api.v1.service;

import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

class ServiceApiImplTest {

    @InjectMocks
    private ServiceApiImpl serviceApi;

    @Mock
    private ServiceMapper serviceMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateService_shouldCall_serviceMapper() {
        ServiceRequest request = new ServiceRequest();
        request.setDate(Instant.now());

        serviceApi.createService(request);
        verify(serviceMapper).createService(anyString());
        verify(serviceMapper).getServiceByDate(anyString());
    }
}