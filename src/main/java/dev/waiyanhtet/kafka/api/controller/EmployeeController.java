package dev.waiyanhtet.kafka.api.controller;

import dev.waiyanhtet.kafka.api.request.Employee;
import dev.waiyanhtet.kafka.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final RegistrationService registrationService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> register(
            @RequestBody Employee employee) {
        return new ResponseEntity<>(registrationService.register(employee), HttpStatus.OK);
    }
}
