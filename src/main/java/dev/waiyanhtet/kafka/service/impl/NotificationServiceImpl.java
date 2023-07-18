package dev.waiyanhtet.kafka.service.impl;

import dev.waiyanhtet.kafka.dto.Employee;
import dev.waiyanhtet.kafka.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendNotification(Employee employee) {
        log.info(employee.toString());
        kafkaTemplate.send("my-topic", employee);
    }
}
