package com.paltform.attendance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.paltform.attendance.model.EmployeePresentTime;
import com.paltform.attendance.model.entity.EmployeeTimeTrace;
import com.paltform.attendance.repository.AttendanceRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    public void saveAttendance(String value){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        EmployeePresentTime employeePresentTime = null;
        try {
            employeePresentTime = mapper.readValue(value, EmployeePresentTime.class);
        }catch (JsonProcessingException parseException){
            parseException.getMessage();
        }

        EmployeeTimeTrace employeeTimeTrace = EmployeeTimeTrace.builder()
                .empId(employeePresentTime.getEmployeeId())
                .date(employeePresentTime.getDate())
                .time(employeePresentTime.getPresentHours())
                .status(employeePresentTime.getAttendance())
                .build();

        attendanceRepository.save(employeeTimeTrace);

        System.out.println("data" + employeePresentTime);
    }
}
