package com.jtmc.apps.reforma.api.v1.service;

import com.jtmc.apps.reforma.domain.Service;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ServiceApiImplTest {

    @InjectMocks
    private ServiceApiImpl serviceApi;

    @Mock
    private ServiceMapper serviceMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        when(serviceMapper.getServiceByDate(anyString())).thenReturn(new Service());
    }

    @Test
    void testCreateService_shouldCall_serviceMapper() {
        ServiceRequest request = new ServiceRequest();
        request.setDate(Instant.now());

        serviceApi.createService(request);
        verify(serviceMapper).createService(any(LocalDate.class));
    }

    @Test
    void testCreateService_shouldCallCreateServiceMapper_withCorrectDate() {
        //date = july 2 2021 5:22:35 GMT
        long dateEpochSec = 1625203355;
        Instant instant = Instant.ofEpochSecond(dateEpochSec);
        LocalDate localDate = instant.atZone(ZoneId.of("-7")).toLocalDate();

        ServiceRequest request = new ServiceRequest();
        request.setDate(instant);

        Service expectedService = new Service();
        expectedService.setId(1);
        expectedService.setDate(instant);

        when(serviceMapper.getServiceByDate(anyString())).thenReturn(expectedService);

        ServiceResponse actualResponse = serviceApi.createService(request);

        Assertions.assertEquals(expectedService.getId(), actualResponse.getId());

        verify(serviceMapper, times(1)).createService(localDate);
        verify(serviceMapper, times(1)).getServiceByDate(localDate.toString());
    }
}