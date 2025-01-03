package com.dm.kafka.service;

import com.dm.kafka.entity.Employee;
import com.dm.kafka.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Mono<Employee> createEmployee(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now()); // Set the current timestamp
        return employeeRepository.save(employee);
    }

    public Flux<Employee> getEmployeesCreatedInLastHour() {
        // Calculate the start time for the last hour
        LocalDateTime oneHourAgo = LocalDateTime.now().minusMinutes(5);

        // Fetch employees created in the last hour
        return employeeRepository.findEmployeesCreatedInLastHour(oneHourAgo);
    }
}

