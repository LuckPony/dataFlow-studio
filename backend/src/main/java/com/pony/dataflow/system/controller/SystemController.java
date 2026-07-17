package com.pony.dataflow.system.controller;

import com.pony.dataflow.system.dto.SystemStatusResponse;
import com.pony.dataflow.system.service.SystemStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/system")
public class SystemController {

    private final SystemStatusService systemStatusService;

    public SystemController(SystemStatusService systemStatusService) {
        this.systemStatusService = systemStatusService;
    }

    @GetMapping("/status")
    public SystemStatusResponse getStatus() {
        return systemStatusService.getStatus();
    }
}