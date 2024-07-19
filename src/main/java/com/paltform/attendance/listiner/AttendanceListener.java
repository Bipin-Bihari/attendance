package com.paltform.attendance.listiner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.paltform.attendance.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AttendanceListener {

    @Autowired
    AttendanceService attendanceService;

    @KafkaListener(topics = "Attendance-Topic",groupId = "attendance-group")
    public void consume1(MysqlxDatatypes.Scalar.String message) {
        log.info("consumer1 reading message : "+ message);
        attendanceService.saveAttendance(message);
    }

    @KafkaListener(topics = "Attendance-Topic",groupId = "attendance-group")
    public void consume2(MysqlxDatatypes.Scalar.String message){
        log.info("consumer2 reading message : "+ message);
        attendanceService.saveAttendance(message);
    }

    @KafkaListener(topics = "Attendance-Topic",groupId = "attendance-group")
    public void consume3(MysqlxDatatypes.Scalar.String message){
        log.info("consumer3 reading message : "+ message);
        attendanceService.saveAttendance(message);
    }
}
