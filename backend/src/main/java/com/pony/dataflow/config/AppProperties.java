package com.pony.dataflow.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DataFlow Studio 自定义应用配置。
 *
 * @param displayName 应用显示名称
 * @param version 应用版本
 * @param environment 当前运行环境
 */
@ConfigurationProperties(prefix = "app")
public record AppProperties(
        String displayName,
        String version,
        String environment
) {
}
