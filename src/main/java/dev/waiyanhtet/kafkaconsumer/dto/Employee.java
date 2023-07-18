package dev.waiyanhtet.kafkaconsumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder( value = {
        "name, address, email"
})
public class Employee implements Serializable {

    @JsonProperty
    private String name;
    @JsonProperty
    private String email;
    @JsonProperty
    private String address;

}
