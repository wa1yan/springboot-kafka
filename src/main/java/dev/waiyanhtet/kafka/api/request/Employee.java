package dev.waiyanhtet.kafka.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee {

    private String name;
    private String email;
    private String address;

}
