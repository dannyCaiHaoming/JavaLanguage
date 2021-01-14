# SpringDataJPA
一句话即系：**通过解析方法名创建查询**。

什么是`JPA`?
SpringData JPA是SpringData中的一个子模块。 `SpringData`又是啥？？

`JPA`是一套标准接口，`Java Persistentce API`,而`Hibernate`是`JAP`的实现。

SpringData JPA的底层默认实现是`Hibernate`



# SpringData JPA 配置

- `pom.xml`中添加依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
- `application.xml`中配置数据库连接信息
```
spring: 
    datasource:
        username: xx
        password: xx
        driver-class-name: xx  
        url: jdbc:mysql: localhost:3306/库名字?userUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
# JPA配置
jpa:
    hibernate:
        ddl-auto:update 
    show-sql: true
    # formatSQL的这样写
    properties:
        hibernate:
            formate_sql: true
```

`ddl-auto`是`hibernate`的配置参数，其主要作用是自动创建、更新、验证数据库表结构。

# SpringData JPA 接口

## 创建实体-@Entry

```
@Entry
public class User {
    private Long id;
    private String name;
    private Integer age;
}
```

创建一个`User`实体，通过`ORM`框架其会被映射到数据库表中。

## Repository 

`Repository`是一个标记接口。只要我们的接口实现这个接口，那么我们相当于在使用`SpringData JPA`。

```
public interface UserRepository extends JpaRepository<User,Long> {

}
```

在SpringData JPA中，只要编写了`JpaRepository`接口的扩展，就可以实现数据的访问。
默认有:
- `save` 创建
- `save` 更新
- `delete` 删除
- `findAll` 查询
- `findOne` 查询

