package dev.waiyanhtet.kafka.service.impl;

import dev.waiyanhtet.kafka.api.request.Employee;
import dev.waiyanhtet.kafka.service.NotificationService;
import dev.waiyanhtet.kafka.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeRegistrationServiceImpl implements RegistrationService {

    private final NotificationService notificationService;
    @Override
    public Employee register(Employee employee) {

        //register in db
        log.info("Empolyee : " + employee.toString());
        notificationService.sendNotification(employee);
        return employee;
    }
}
