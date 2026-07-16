# DataFlow Studio

A low-code data cleansing, task orchestration, and visualization platform.

## Project Goal

DataFlow Studio allows users to upload CSV datasets, execute configurable
data-cleansing workflows through n8n, monitor task progress in real time,
and visualize the processing results.

## Architecture

- Backend: Java 21, Spring Boot, MyBatis-Plus
- Frontend: Vue 3, TypeScript, Vite
- Database: MySQL
- Cache: Redis
- Low-code workflow: n8n
- Deployment: Docker Compose

## Repository Structure

```text
backend/       Spring Boot backend
frontend/      Vue frontend
infra/         Infrastructure configuration
docs/          Project documentation
scripts/       Development scripts
sample-data/   Sample CSV datasets
```
## DataFlow Studio

一个低代码的数据清洗、任务编排与可视化平台。

## 项目目标

DataFlow Studio 允许用户上传 CSV 数据集，通过 n8n 执行可配置的数据清洗工作流，实时监控任务进度，并将处理结果进行可视化展示。

## 技术架构

后端：Java 21, Spring Boot, MyBatis-Plus
前端：Vue 3, TypeScript, Vite
数据库：MySQL
数据库的变更：通过Flyway迁移来管理。
缓存：Redis
低代码工作流：n8n
部署方式：Docker Compose

## 仓库目录结构

backend/       Spring Boot 后端
frontend/      Vue 前端
infra/         基础设施配置
docs/          项目文档
scripts/       开发脚本
sample-data/   CSV 示例数据集

