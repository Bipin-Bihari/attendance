package com.paltform.attendance.repository;

import com.paltform.attendance.model.entity.EmployeeTimeTrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<EmployeeTimeTrace,Integer> {

}
