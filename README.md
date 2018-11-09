# GUC 通用用户中心系统: User Account and Authentication (UAA) Server

基于Spring Cloud 高可用微服务
************
使用了如下框架

- spring boot 、spring security 、 spring cloud

- spring mvc

- mybatis

- thymeleaf

************
使用方式

1. 下载该demo，git clone https://github.com/laziobird/GUC.git

2. mvn eclipse:eclipse

3. 使用mysql数据库新建系统数据库（sql文件见 (doc/db.sql)，数据库名、数据库用户名、密码自行在application.yml文件内修改，测试账号 admin/admin

4. 修改maven路径（本地路径，修改conf/settings.xml文件镜像用国内的）

5. 等待maven下载相关依赖

6. 运行MainApplication

7. 运行成功后访问 [http://localhost:8080/](http://localhost:8080/)  

************
控制台

![image](https://github.com/laziobird/GUC/blob/master/2.jpeg)

Open API接口

![image](https://github.com/laziobird/GUC/blob/master/1.jpeg)

************

在线预览地址 [http://birdboy.cn/](http://birdboy.cn/)  

