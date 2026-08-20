package org.example.jwtfetch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.xml.datatype.Duration;

@ConfigurationProperties(prefix = "app.auth")
public record AuthProperties(
        String encodingId,
        Jwt jwt
) {
    public record Jwt(
            String secretKey,
            Duration accessTokenExpiry) {
    }
}