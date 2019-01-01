# [Rx](http://60.205.106.190:3000/ryze/Rx) [![Build Status](https://travis-ci.org/idugalic/micro-company.svg?branch=master)](http://60.205.106.190:3000/ryze/Rx)

泓华门诊处方项目V1.0

## 项目架构
 
``` scala
Rx
├── config -- 分布式配置中心
├── config-repo -- 配置文件仓库
├── core -- 核心组件
├── edge -- API网关
├── product -- 产品模块
```

模块 | 端口|说明  
---|---|---  
[config](config/README.md)|8888|配置管理
[config-repo](config/README.md)|-|配置仓库
[core](core/README.md)|-|核心组件
[edge](edge/README.md)|9090|网关
[product](product/README.md)|8085|产品商品
...|...|  

### 技术选型

#### 开发技术:
技术 | 描述 | 官网
----|------|----
Spring Boot | Spring  | [http://projects.spring.io/spring-boot/](http://projects.spring.io/spring-boot/)
Spring Cloud | Spring  | [http://projects.spring.io/spring-cloud/](http://projects.spring.io/spring-cloud/)
Axon | CQRS框架  | [http://www.axonframework.org/](http://www.axonframework.org/)
Rabbit MQ | 消息中间件  | [http://www.rabbitmq.com/](http://www.rabbitmq.com/)
Swagger2 | 接口文档框架  | [http://swagger.io/](http://swagger.io/)
Gradle | 项目构建管理  | [https://gradle.org/](https://gradle.org/)
Docker | 容器 | [https://www.docker.com/](https://www.docker.com/)
... | ... |


#### 开发环境：
- Docker
- JDK8+
- MySQL
- Gradle

#### 开发工具:
- MongoDB、MySQL: 数据库
- Undertow: 应用服务器
- Git: 版本管理
- Nginx: 反向代理服务器
- IntelliJ IDEA: 开发IDE

#### 开发进度

- [x] 搭建架构
- [x] 服务注册
- [x] 服务发现
- [x] 客户端负载均衡
- [x] 云配置中心
- [x] 断路器
- [x] API网关
- [x] 每个服务一个数据库
- [x] 每个服务一个容器
- [x] 使用docker发布微服务
- [x] 消息驱动
- [x] 事件源
- [x] 读写分离
- [x] cqrs
- [x] 产品模块
- [ ] 日志聚合
- [ ] 应用监控
- [ ] 审计日志
- [ ] 分布式跟踪
- [ ] 异常追踪
- [ ] 健康监测

#### 测试服接口文档调试地址

- [产品商品](http://60.205.151.68:8085/index.html)