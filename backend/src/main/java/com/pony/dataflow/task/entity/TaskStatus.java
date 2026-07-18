package com.pony.dataflow.task.entity;

/**
 * 数据清洗任务的生命周期状态。
 */
public enum TaskStatus {

    /**
     * 已创建，等待执行。
     */
    PENDING,

    /**
     * 正在执行数据清洗。
     */
    PROCESSING,

    /**
     * 任务成功完成。
     */
    COMPLETED,

    /**
     * 任务执行失败。
     */
    FAILED
}