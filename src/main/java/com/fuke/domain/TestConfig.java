package com.fuke.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@PropertySource("classpath:resource.properties")
@ConfigurationProperties(prefix = "test")
@Data
public class TestConfig implements Serializable {

    @Value("name")
    private String name;
    @Value("sort")
    private String port;

}
