package com.pony.dataflow.task.entity;

/**
 * 数据清洗任务生命周期。
 */
public enum TaskStatus {

    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED,
    CANCELLED;

    /**
     * 判断当前状态是否允许迁移到目标状态。
     */
    public boolean canTransitionTo(TaskStatus target) {
        return switch (this) {
            case PENDING ->
                    target == PROCESSING || target == CANCELLED;

            case PROCESSING ->
                    target == COMPLETED || target == FAILED;

            case COMPLETED, FAILED, CANCELLED -> false;
        };
    }

    /**
     * 判断任务是否已经结束。
     */
    public boolean isTerminal() {
        return this == COMPLETED
                || this == FAILED
                || this == CANCELLED;
    }
}