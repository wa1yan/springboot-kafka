package dev.waiyanhtet.kafkaconsumer.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private String email;
    private String address;

}
