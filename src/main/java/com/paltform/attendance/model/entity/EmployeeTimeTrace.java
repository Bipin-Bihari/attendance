package com.paltform.attendance.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@Entity(name = "DailyAttendance")
public class EmployeeTimeTrace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int empId;
    private LocalDate date;
    private LocalTime time;
    private String status;
}
