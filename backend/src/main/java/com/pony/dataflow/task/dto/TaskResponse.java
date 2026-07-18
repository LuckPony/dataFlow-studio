package com.pony.dataflow.task.dto;

import com.pony.dataflow.task.entity.DataCleaningTaskEntity;
import com.pony.dataflow.task.entity.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String taskNo,
        String originalFilename,
        TaskStatus status,
        Integer totalRows,
        Integer validRows,
        Integer invalidRows,
        Integer duplicateRows,
        String failureReason,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static TaskResponse from(DataCleaningTaskEntity entity) {
        return new TaskResponse(
                entity.getId(),
                entity.getTaskNo(),
                entity.getOriginalFilename(),
                entity.getStatus(),
                entity.getTotalRows(),
                entity.getValidRows(),
                entity.getInvalidRows(),
                entity.getDuplicateRows(),
                entity.getFailureReason(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}