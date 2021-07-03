package com.jtmc.apps.reforma.api.v1.service;

import com.jtmc.apps.reforma.domain.Service;
import com.jtmc.apps.reforma.impl.exception.ServiceNotFoundException;
import com.jtmc.apps.reforma.impl.service.ServiceImpl;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;
import com.sun.org.glassfish.gmbal.ManagedOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.ParseException;
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

    @Mock
    private ServiceImpl serviceImpl;

    private ServiceRequest serviceRequest = new ServiceRequest();
    private String expectedDate = "2021-05-12";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        when(serviceImpl.getServiceByDate(anyString())).thenReturn(new Service());

        serviceRequest.setDate(expectedDate);
    }

    @Test
    void testCreateService_shouldCall_serviceMapper() {
        serviceApi.createService(serviceRequest);
        verify(serviceMapper).createService(anyString());
    }

    @Test
    void testCreateService_throwsWebAppException_ifParseException() throws Exception {
        doThrow(ParseException.class).when(serviceImpl).validateDateFormat(anyString());

        serviceRequest.setDate("wrong date format");
        Assertions.assertThrows(WebApplicationException.class, () ->
                serviceApi.createService(serviceRequest));

        verifyNoInteractions(serviceMapper);
    }

    @Test
    void testCreateService_shouldCallCreateServiceMapper_withCorrectDate() {
        Service expectedService = new Service();
        expectedService.setId(1);

        when(serviceImpl.getServiceByDate(anyString())).thenReturn(expectedService);

        ServiceResponse actualResponse = serviceApi.createService(serviceRequest);

        Assertions.assertEquals(expectedService.getId(), actualResponse.getId());

        verify(serviceMapper, times(1)).createService(expectedDate);
        verify(serviceImpl, times(1)).getServiceByDate(expectedDate);
    }

    @Test
    void testGetServiceByDate_shouldCall_validateDateFormat() throws Exception {
        serviceApi.getServiceByDate(expectedDate);
        verify(serviceImpl, times(1)).validateDateFormat(anyString());
    }

    @Test
    void testGetServiceByDate_shouldCall_serviceImpl_getServiceByDate() throws Exception {
        serviceApi.getServiceByDate(expectedDate);
        verify(serviceImpl).getServiceByDate(anyString());
    }

    @Test
    void testGetServiceByDate_throwsWebAppException_whenWrongFormat() throws Exception {
        doThrow(ParseException.class).when(serviceImpl).validateDateFormat(anyString());
        Assertions.assertThrows(WebApplicationException.class, () ->
                serviceApi.getServiceByDate("wrong date"));
        verifyNoInteractions(serviceMapper);
    }

    @Test
    void testGetServiceByDate_throwsNotFoundException() throws Exception {
        doNothing().when(serviceImpl).validateDateFormat(anyString());
        doThrow(ServiceNotFoundException.class).when(serviceImpl).getServiceByDate(anyString());

        Assertions.assertThrows(ServiceNotFoundException.class, () ->
                serviceApi.getServiceByDate(expectedDate));
    }

    @Test
    void testGetServiceByDate_returnsCorrectServiceResponse() {

        Service expectedService = new Service();
        expectedService.setId(4);
        when(serviceImpl.getServiceByDate(anyString())).thenReturn(expectedService);

        ServiceResponse actualServiceResponse = serviceApi.getServiceByDate(expectedDate);

        Assertions.assertEquals(expectedService.getId(), actualServiceResponse.getId());
    }
}