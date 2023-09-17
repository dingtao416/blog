# CM BLOG

<p align="center">
	<img src="https://img.shields.io/badge/JDK-1.8+-orange">
	<img src="https://img.shields.io/badge/SpringBoot-2.2.7.RELEASE-brightgreen">
	<img src="https://img.shields.io/badge/MyBatis-3.5.5-red">
	<img src="https://img.shields.io/badge/license-MIT-blue">
</p>

## 简介

Spring Boot +thymeleaf博客系统

## 后端

1. 核心框架：[Spring Boot](https://github.com/spring-projects/spring-boot)
2. ORM 框架：[MyBatis](https://github.com/mybatis/spring-boot-starter)
3. 分页插件：[PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)
4. Markdown 转 HTML：[commonmark-java](https://github.com/commonmark/commonmark-java)

## 前端

Thymeleaf

## 开发环境

1. 创建 MySQL 数据库`blog`，并执行`/blog/myblog.sql`初始化表数据
2. 修改配置信息`src/main/resources/application-dev.yml`中的数据库账号和密码(建表数据库名如果修改，则也应该在数据库中进行修改)
3. 启动后端服务
4. 访问用户登录页 [登录界面](http://localhost:8080/user/login) 账号：user密码：123456  管理员登录页 [登录界面](http://localhost:8080/admin/login)

账号：admin 密码: 123456

## LICENSE

[MIT](https://github.com/Naccl/NBlog/blob/master/LICENSE)

## Thanks

感谢 [JetBrains](https://www.jetbrains.com/?from=NBlog) 提供的 Open Source License

感谢上面提到的每个开源项目