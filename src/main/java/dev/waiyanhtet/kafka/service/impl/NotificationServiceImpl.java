package dev.waiyanhtet.kafka.service.impl;

import dev.waiyanhtet.kafka.api.request.Employee;
import dev.waiyanhtet.kafka.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private KafkaTemplate<String, Object> employeeKafkaTemplate;

    @Override
    public void sendNotification(Employee employee) {
        employeeKafkaTemplate.send("employeeTopic", employee);
    }
}
