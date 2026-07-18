package com.pony.dataflow.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pony.dataflow.task.entity.DataCleaningTaskEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataCleaningTaskMapper
        extends BaseMapper<DataCleaningTaskEntity> {
}