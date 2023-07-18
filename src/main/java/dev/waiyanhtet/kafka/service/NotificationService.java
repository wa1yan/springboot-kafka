package dev.waiyanhtet.kafka.service;

import dev.waiyanhtet.kafka.dto.Employee;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

    void sendNotification(Employee employee);
}
