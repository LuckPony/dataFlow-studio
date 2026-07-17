package com.pony.dataflow.system.dto;

import java.time.Instant;

public record SystemStatusResponse(
        String application,
        String version,
        String environment,
        String status,
        Instant timestamp
) {
}