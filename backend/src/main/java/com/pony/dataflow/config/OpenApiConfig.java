package com.pony.dataflow.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI dataFlowOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("DataFlow Studio API")
                        .version("v1")
                        .description(
                                "Low-code data cleansing and workflow "
                                        + "orchestration platform API"
                        ))
                .tags(List.of(
                        new Tag()
                                .name("Task Management")
                                .description(
                                        "Create, query and manage "
                                                + "data-cleaning tasks"
                                )
                ));
    }
}