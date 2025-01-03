package com.dm.kafka.repository;


import com.dm.kafka.entity.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

    @Query("SELECT * FROM employees WHERE created_at >= :startTime")
    Flux<Employee> findEmployeesCreatedInLastHour(@Param("startTime") LocalDateTime startTime);
}
