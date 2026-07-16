# DataFlow Studio Architecture

## 1. Core Use Case

A user uploads a CSV file and creates a data-cleansing task.

The backend stores the task metadata and triggers an n8n workflow.
The n8n workflow obtains the data, executes cleansing rules, and sends
the processed result back to the backend.

The frontend receives task progress through Server-Sent Events.

## 2. Main Components

### Frontend

Responsibilities:

- File upload
- Task list
- Task detail
- Real-time progress
- Data visualization

### Backend

Responsibilities:

- Authentication and authorization
- File validation
- Task lifecycle management
- Database persistence
- Cache management
- n8n integration
- SSE event delivery

### n8n

Responsibilities:

- Workflow orchestration
- Standard processing nodes
- JavaScript rule execution
- External service integration

### MySQL

Stores:

- Users
- Tasks
- Uploaded dataset metadata
- Cleansing rules
- Cleansing results
- Audit records

### Redis

Stores:

- Task status cache
- Temporary progress
- Short-lived authentication data
- Idempotency keys

## 3. Initial Request Flow

```text
Browser
  |
  | POST /api/tasks
  v
Spring Boot
  |
  | INSERT task
  v
MySQL
  |
  | Trigger webhook
  v
n8n
  |
  | Callback result
  v
Spring Boot
  |
  | Persist result and publish progress
  +--------> MySQL
  +--------> Redis
  +--------> SSE
                |
                v
              Browser


DataFlow Studio 架构设计
1. 核心业务场景

用户上传 CSV 文件并创建数据清洗任务。
后端负责存储任务元数据并触发 n8n 工作流。
n8n 工作流获取数据、执行清洗规则，并将处理后的结果回传给后端。
前端通过 SSE（Server-Sent Events，服务器发送事件）接收任务的实时进度。

2. 主要组件

前端 (Frontend)

职责：
文件上传
任务列表
任务详情
实时进度展示
数据可视化


后端 (Backend)

职责：
身份认证与授权
文件校验
任务生命周期管理
数据库持久化
缓存管理
n8n 服务集成
SSE 事件推送

### n8n

职责：
工作流编排
提供标准处理节点
执行 JavaScript 清洗规则
外部服务集成

MySQL (关系型数据库)

存储内容：
用户信息
任务信息
已上传数据集的元数据
清洗规则
清洗结果
审计记录

Redis (缓存数据库)

存储内容：
任务状态缓存
临时进度数据
短期有效的认证数据
幂等性键（用于防止请求被重复处理）

3. 初始请求流程
浏览器 (Browser)

  |
  | POST /api/tasks (创建任务请求)
  v
Spring Boot 后端

  |
  | INSERT task (插入任务记录)
  v
MySQL 数据库

  |
  | Trigger webhook (触发 Webhook)
  v
n8n 工作流

  |
  | Callback result (回调处理结果)
  v
Spring Boot 后端

  |
  | Persist result and publish progress (持久化结果并发布进度)
  +--------> MySQL (写入结果)
  +--------> Redis (更新缓存进度)
  +--------> SSE (推送事件)

                |
                v
              浏览器 (Browser)

---



