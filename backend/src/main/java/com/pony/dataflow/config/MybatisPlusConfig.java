package com.pony.dataflow.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.pony.dataflow.task.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor =
                new MybatisPlusInterceptor();

        // 防止并发更新互相覆盖
        interceptor.addInnerInterceptor(
                new OptimisticLockerInnerInterceptor()
        );

        // 分页插件通常放在其他插件之后
        interceptor.addInnerInterceptor(
                new PaginationInnerInterceptor(DbType.MYSQL)
        );

        return interceptor;
    }
}