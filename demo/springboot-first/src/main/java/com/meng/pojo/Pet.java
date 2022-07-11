package com.meng.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pet")
@ToString
public class Pet {
    private String name;
    private Integer age;
    private String color;
}
