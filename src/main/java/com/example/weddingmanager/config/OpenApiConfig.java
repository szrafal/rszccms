package com.example.weddingmanager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI weddingManagerOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Wedding Manager API")
                        .description("REST API for managing wedding guests")
                        .version("v1")
                        .contact(new Contact().name("Wedding Manager Team"))
                        .license(new License().name("Internal use")));
    }
}
