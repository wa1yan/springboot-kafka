//package dev.waiyanhtet.kafkaconsumer.config;
//
//import dev.waiyanhtet.kafkaconsumer.dto.Employee;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.TypeConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.ConsumerProperties;
//import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//@EnableKafka
//@Configuration
//public class KafkaObjectConsumerConfig {
//
//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapServerAddress;
//
//    @Bean
//    public ConsumerFactory<String, Employee> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        return new DefaultKafkaConsumerFactory<>(props,
//                new StringDeserializer(),
//                new JsonDeserializer<>(Employee.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Employee> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Employee>
//                factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//}
