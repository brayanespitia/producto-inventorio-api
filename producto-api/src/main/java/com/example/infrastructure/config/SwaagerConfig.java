package com.example.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SwaagerConfig {
    @Bean
    public OpenAPI productServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Service API")
                        .description("API for managing products (JSON:API compliant)")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Brayan Espitia")
                                .url("https://github.com/brayanespitia")
                                .email("brayan@example.com"))
                );
    }
}
