package dev.waiyanhtet.kafka.service;

import dev.waiyanhtet.kafka.api.request.Employee;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {
    Employee register(Employee employee);
}
