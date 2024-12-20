package com.example.crud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI crudServiceAPI() {
        return new OpenAPI()
                .info(new Info().title("Crud Service API")
                .description("REST API for CRUD microservice")
                .version("0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                        .externalDocs(new ExternalDocumentation()
                .description("Springdoc OpenAPI 3.0").url("https://springdoc.org/"));
    }
}
