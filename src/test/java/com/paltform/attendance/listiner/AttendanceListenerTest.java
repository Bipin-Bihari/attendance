package com.paltform.attendance.listiner;

import com.paltform.attendance.service.AttendanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;

class AttendanceListenerTest {

    @Mock
    private AttendanceService attendanceService;

    @InjectMocks
    private AttendanceListener attendanceListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsume1() {
        String message = "Test Message 1";
        attendanceListener.consume1(message);
        Mockito.verify(attendanceService, Mockito.times(1)).saveAttendance(message);
    }

    @Test
    void testConsume2() {
        String message = "Test Message 2";
        attendanceListener.consume2(message);
        Mockito.verify(attendanceService, Mockito.times(1)).saveAttendance(message);
    }

    @Test
    void testConsume3() {
        String message = "Test Message 3";
        attendanceListener.consume3(message);
        Mockito.verify(attendanceService, Mockito.times(1)).saveAttendance(message);
    }
}
