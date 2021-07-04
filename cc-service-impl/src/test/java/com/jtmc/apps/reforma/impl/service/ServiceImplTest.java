package com.jtmc.apps.reforma.impl.service;

import com.google.common.collect.Lists;
import com.jtmc.apps.reforma.domain.Attendance;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona.PersonaMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class ServiceImplTest {

    @InjectMocks
    private ServiceImpl service;

    @Mock
    private PersonaMapper personaMapper;

    @Mock
    private AttendanceMapper attendanceMapper;

    private EasyRandom easyRandom = new EasyRandom();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAttendanceList_returnsCorrectData() {
        List<Persona> expectedPersonas =
                easyRandom.objects(Persona.class, 5)
                        .collect(Collectors.toList());
        when(personaMapper.selectAllPersonas())
                .thenReturn(expectedPersonas);

        int randomPick = easyRandom.nextInt(5) + 1;
        int matchedPersonaId = expectedPersonas.get(randomPick).getId();

        Attendance expectedAttendace = easyRandom.nextObject(Attendance.class);
        expectedAttendace.getPersona().setId(matchedPersonaId);

        when(attendanceMapper.selectWhereIdServiceAndAttendedTrue(anyInt()))
                .thenReturn(Lists.newArrayList(expectedAttendace));

        Collection<Attendance> actualAttendances =
                service.getAttendanceListByServiceId(1);

        actualAttendances.stream().forEach(attendance -> {
            if (attendance.getPersona().getId() == matchedPersonaId) {
                Assertions.assertTrue(attendance.isAttended());
            } else {
                Assertions.assertFalse(attendance.isAttended());
            }
        });
    }
}