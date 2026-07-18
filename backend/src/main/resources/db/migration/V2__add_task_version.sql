ALTER TABLE data_cleaning_task
    ADD COLUMN version INT UNSIGNED NOT NULL DEFAULT 0
        COMMENT 'Optimistic locking version'
        AFTER updated_at;