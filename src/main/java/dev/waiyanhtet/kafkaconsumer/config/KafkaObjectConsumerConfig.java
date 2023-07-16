package dev.waiyanhtet.kafkaconsumer.config;

import dev.waiyanhtet.kafkaconsumer.dto.Employee;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaObjectConsumerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapServerAddress;

    @Bean
    public ConsumerFactory<String, Employee> employeeConsumerFactory() {
        JsonDeserializer<Employee> deserialer = new JsonDeserializer<>(Employee.class);
        deserialer.addTrustedPackages("dev.waiyanhtet.kafka.api.request.Employee");
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "groupId");
        //props.put(JsonDeserializer.TYPE_MAPPINGS, "employee:dev.waiyanhtet.kafkaconsumer.dto.Employee");
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                deserialer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Employee> employeeKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Employee> factory = new ConcurrentKafkaListenerContainerFactory<String, Employee>();
        factory.setConsumerFactory(employeeConsumerFactory());
        return factory;
    }
}
