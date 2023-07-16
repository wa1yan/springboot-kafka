package dev.waiyanhtet.kafkaconsumer.listener;

import dev.waiyanhtet.kafkaconsumer.dto.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CommonKafkaListener {

 //   @KafkaListener(topics = {"topic1"}, groupId = "groupId1")
    public void listenerGroup1(String message) {
        System.out.println("Message for group 1 : " + message);
    }

//    @KafkaListener(topicPartitions = @TopicPartition(topic = "topic2", partitionOffsets = {
//            @PartitionOffset(partition = "0", initialOffset = "0"),
//            @PartitionOffset(partition = "1", initialOffset = "0")
//    }))
    public void listenerGroup2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partion) {
        System.out.println("Message : " + message);
        System.out.println("Partion : " + partion);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "employeeTopic",
                    partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0"),
                                        @PartitionOffset(partition = "1", initialOffset = "0")}),
            containerFactory = "employeeKafkaListenerContainerFactory")
    public void EmployeeListener(Employee employee) {
        System.out.println(employee.toString());
    }
}
