package com.dm.kafka.config;

import com.dm.kafka.entity.Employee;
import com.dm.kafka.producer.KafkaProducer;
import com.dm.kafka.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ScheduledTask {

    private final EmployeeService employeeService;
    private final KafkaProducer kafkaProducer;

    @Autowired
    public ScheduledTask(EmployeeService employeeService, KafkaProducer kafkaProducer) {
        this.employeeService = employeeService;
        this.kafkaProducer = kafkaProducer;
    }

    // Every hour, fetch new employees and send them to Kafka
    @Scheduled(fixedRate = 300000) // Cron expression to run every hour
    public void sendEmployeesToKafka() {
        // Get employees created in the last hour
        Flux<Employee> employees = employeeService.getEmployeesCreatedInLastHour();

        // Convert employees to JSON or String format
        employees
                .map(employee -> {
                    try {
                        return new ObjectMapper().writeValueAsString(employee);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })  // Use Jackson to convert to JSON
                .doOnNext(employeeJson -> kafkaProducer.sendEmployeeDataToKafka("kafkaTopic1_json", employeeJson))
                .subscribe();  // Subscribe to the Flux to trigger the operation
    }
}

