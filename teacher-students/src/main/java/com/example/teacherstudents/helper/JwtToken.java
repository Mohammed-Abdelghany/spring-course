package com.example.teacherstudents.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "token")
public class JwtToken {
    private String secretKey;
    private Duration duration;
}
