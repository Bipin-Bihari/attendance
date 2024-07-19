package com.paltform.attendance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.paltform.attendance.model.EmployeePresentTime;
import com.paltform.attendance.model.entity.EmployeeTimeTrace;
import com.paltform.attendance.repository.AttendanceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

class AttendanceServiceTest {

    @Mock
    private AttendanceRepository attendanceRepository;

    @InjectMocks
    private AttendanceService attendanceService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void testSaveAttendance() throws Exception {
        // Given
        String json = "{\"employeeId\":1,\"date\":\"2024-03-06\",\"presentHours\":8,\"attendance\":\"PRESENT\"}";
        EmployeePresentTime employeePresentTime = objectMapper.readValue(json, EmployeePresentTime.class);

        // When
        attendanceService.saveAttendance(json);

        // Then
        Mockito.verify(attendanceRepository, Mockito.times(1))
                .save(any(EmployeeTimeTrace.class));
    }
}
