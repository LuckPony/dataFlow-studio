package com.pony.dataflow.task.exception;

public class TaskStateConflictException
        extends RuntimeException {

    public TaskStateConflictException(String message) {
        super(message);
    }
}