CREATE TABLE data_cleaning_task
(
    id                BIGINT UNSIGNED NOT NULL AUTO_INCREMENT
        COMMENT 'Primary key',

    task_no           CHAR(32) NOT NULL
        COMMENT 'Globally unique task number',

    original_filename VARCHAR(255) NOT NULL
        COMMENT 'Original uploaded filename',

    status            VARCHAR(32) NOT NULL
        COMMENT 'Task status',

    total_rows        INT UNSIGNED NOT NULL DEFAULT 0
        COMMENT 'Total number of rows',

    valid_rows        INT UNSIGNED NOT NULL DEFAULT 0
        COMMENT 'Number of valid rows',

    invalid_rows      INT UNSIGNED NOT NULL DEFAULT 0
        COMMENT 'Number of invalid rows',

    duplicate_rows    INT UNSIGNED NOT NULL DEFAULT 0
        COMMENT 'Number of duplicate rows',

    failure_reason    VARCHAR(500) NULL
        COMMENT 'Failure reason',

    created_at        DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
        COMMENT 'Creation time',

    updated_at        DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
        ON UPDATE CURRENT_TIMESTAMP(6)
        COMMENT 'Last update time',

    PRIMARY KEY (id),

    UNIQUE KEY uk_data_cleaning_task_task_no (task_no),

    KEY idx_data_cleaning_task_status_created_at
        (status, created_at)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    COMMENT = 'Data cleaning task';