### 本脚手架调整基于RY_Cloud 3.x升级为 springboot3.0 jdk17
因springboot3.0以及jdk17升级，依赖升级对稳定性不确定性原因，  
为避免对ruoyi作者产生纠纷，因此将author替换成raise，如有侵权请及时联系qq 353735348。  
本框架不可以使用到生产环境，因本框架造成的任何损失，请自行承担！

# Boot3-framework
Springboot3.0  
JDK 17  
SpringCloud 2022.0.2   
SpringCloud Alibaba 2022.0.0.0-RC1      
FastJson 2.0  
spring gateway  
nacos 2.2.1  
sentinel  
seata  
Apache poi  

### 持久层
Mybatis-Plus  
Mysql 8.0.x  
Elasticsearch待定   
Mongo待定    

### MQ
Apache Kafka   
Apache RabbitMQ

### Cache
Memcached  
Redis

### 前端
https://pro.ant.design/zh-CN/
antd pro 5.0  
umi 3.5
https://v3.umijs.org/


### 运维搭建过程
1. 安装nacos
2. 创建业务数据库，导入 ry_20220814.sql
3. 创建nacos数据库， 导入nacos-mysql-schema.sql;导入nacos ry配置nacos-biz-init.sql
4. nacos配置文件修改nacos.core.auth.plugin.nacos.token.secret.key为
```
正式环境要修改以下key
nacos.core.auth.plugin.nacos.token.secret.key=SecretKey012345678901234567890123456789012345678901234567890123456789
```
5. 单节点启动nacos
```
sh startup.sh -m standalone
```
6. nacos测试登陆
```
http://192.168.3.95:8848/nacos 
nacos
nacos
```

#### jdbc连接如下
192.168.3.4:3306/db_boot3

### 前端React
建议 Nodejs 18

