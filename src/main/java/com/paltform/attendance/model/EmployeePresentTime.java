package com.paltform.attendance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePresentTime {
    private int employeeId;
    private LocalTime presentHours;
    private LocalDate date;
    private String attendance;
}
