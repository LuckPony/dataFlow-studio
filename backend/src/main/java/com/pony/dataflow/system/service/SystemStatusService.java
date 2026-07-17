package com.pony.dataflow.system.service;

import com.pony.dataflow.config.AppProperties;
import com.pony.dataflow.system.dto.SystemStatusResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SystemStatusService {

    private final AppProperties appProperties;

    public SystemStatusService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }
 
    public SystemStatusResponse getStatus() {
        return new SystemStatusResponse(
                appProperties.displayName(),
                appProperties.version(),
                appProperties.environment(),
                "UP",
                Instant.now()
        );
    }
}