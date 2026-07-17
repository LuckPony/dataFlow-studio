package com.pony.dataflow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DataFlowBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataFlowBackendApplication.class, args);
    }
}

