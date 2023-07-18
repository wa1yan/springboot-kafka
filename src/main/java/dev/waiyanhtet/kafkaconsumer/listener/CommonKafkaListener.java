package dev.waiyanhtet.kafkaconsumer.listener;

import dev.waiyanhtet.kafkaconsumer.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommonKafkaListener {

    @KafkaListener(
            topics = "my-topic", groupId = "group-id")//containerFactory = "kafkaListenerContainerFactory")
    public void consume(Employee employee) {
        log.info("Name : " + employee.getName() + " Email : " + employee.getEmail() + " Address : " + employee.getAddress());
    }
}
