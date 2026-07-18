package com.pony.dataflow.task.service;

import com.pony.dataflow.task.dto.CreateTaskRequest;
import com.pony.dataflow.task.dto.TaskResponse;
import com.pony.dataflow.task.entity.DataCleaningTaskEntity;
import com.pony.dataflow.task.entity.TaskStatus;
import com.pony.dataflow.task.exception.TaskNotFoundException;
import com.pony.dataflow.task.mapper.DataCleaningTaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TaskService {

    private final DataCleaningTaskMapper taskMapper;

    public TaskService(DataCleaningTaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Transactional
    public TaskResponse createTask(CreateTaskRequest request) {
        LocalDateTime now = LocalDateTime.now();

        DataCleaningTaskEntity entity = new DataCleaningTaskEntity();

        entity.setTaskNo(generateTaskNumber());
        entity.setOriginalFilename(request.originalFilename().trim());
        entity.setStatus(TaskStatus.PENDING);

        entity.setTotalRows(0);
        entity.setValidRows(0);
        entity.setInvalidRows(0);
        entity.setDuplicateRows(0);

        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

        int affectedRows = taskMapper.insert(entity);

        if (affectedRows != 1) {
            throw new IllegalStateException(
                    "Failed to create data cleaning task"
            );
        }

        return TaskResponse.from(entity);
    }

    @Transactional(readOnly = true)
    public TaskResponse getTask(Long taskId) {
        DataCleaningTaskEntity entity = taskMapper.selectById(taskId);

        if (entity == null) {
            throw new TaskNotFoundException(taskId);
        }

        return TaskResponse.from(entity);
    }

    private String generateTaskNumber() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "");
    }
}