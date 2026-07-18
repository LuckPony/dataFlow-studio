package com.pony.dataflow.task.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long taskId) {
        super("Data cleaning task not found: " + taskId);
    }
}