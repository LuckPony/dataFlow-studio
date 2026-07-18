package com.pony.dataflow.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(

        @NotBlank(message = "Original filename must not be blank")
        @Size(
                max = 255,
                message = "Original filename must not exceed 255 characters"
        )
        String originalFilename
) {
}