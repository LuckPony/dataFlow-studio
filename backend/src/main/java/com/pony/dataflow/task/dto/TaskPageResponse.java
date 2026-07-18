package com.pony.dataflow.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "分页的任务结果")
public record TaskPageResponse(

        List<TaskResponse> items,

        long page,

        long size,

        long totalElements,

        long totalPages
) {
}