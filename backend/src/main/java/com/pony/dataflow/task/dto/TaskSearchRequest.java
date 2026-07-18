package com.pony.dataflow.task.dto;

import com.pony.dataflow.task.entity.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Schema(description = "任务搜索条件")
public class TaskSearchRequest {

    @Min(value = 1, message = "Page number must be at least 1")
    @Schema(
            description = "页码至少为1",
            example = "1",
            defaultValue = "1"
    )
    private Integer page = 1;

    @Min(value = 1, message = "Page size must be at least 1")
    @Max(value = 100, message = "Page size must not exceed 100")
    @Schema(
            description = "每一页的记录数",
            example = "10",
            defaultValue = "10"
    )
    private Integer size = 10;

    @Schema(
            description = "任务状态",
            example = "PENDING"
    )
    private TaskStatus status;

    @Size(
            max = 100,
            message = "Keyword must not exceed 100 characters"
    )
    @Schema(
            description = "通过任务编号或原始文件名进行搜索",
            example = "customers"
    )
    private String keyword;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}