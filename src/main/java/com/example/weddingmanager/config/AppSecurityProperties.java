package com.example.weddingmanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.security")
public record AppSecurityProperties(String defaultUsername, String defaultPassword) {
}
