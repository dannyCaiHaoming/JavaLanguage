# Spring开发


## IoC容器（ Invert of Control 控制反转）

主要概念，就是使用一个容器去管理我们常需要管理的一些类，达到我们不用每次用的时候都要关注创建和依赖关系，还有销毁的问题。通过依赖注入的手段处理依赖关系。


### 转配Bean


### 使用`Annotation`配置

解决使用xml配置文件去一个个创建装配Bean。使用编码自动在代码?编译?的时候让`Spring`扫描并且装配。

- `@Component`：定义一个Bean，可选名称是小写的类名称。
- `@Autowired`：把指定类型的Bean注入到指定的字段中。
- `@Configuration`: 标注配置类，
- `@ComponentScan`: 告诉容器，自动扫描当前类所在的包以及子包


### 定制Bean


#### Scope

- `@Scope`：`@Component`标记后，Spring容器会自动创建一个单例，`@Scope`，则每次返回一个新的实例。
```
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class XXXXX {}
```

#### 注入List
```
public interface Validator {}

@Component 
@Order(1)
public class EmailValidator implement Validator {}

@Component 
@Order(2)
public class PwdValidator implement Validator {}

@Component 
@Order(3)
public class NameValidator implement Validator {}

@Component
public class Validators {
    @Autowired
    List<Validator> validators;
    // Spring会扫描所有类型为`Validator`的Bean，然后注入到当前List中。
    // 因为List是有序的，可以使用`@Order(x)`，控制加载顺序。
}
```


#### 可选注入

```
@Autowired(required = false)
```
`@Autowired`增加`required = false`参数，作为可选，避免Spring找不到对应类型的Bean的时候抛出异常`NoSuchBeanDefinitionException`。


#### 创建第三方Bean

如果需要加载一个不在当前`package`管理之内的Bean，我们需要在`@Configuration`类中编写一个Java方法创建和返回，注意需要使用`@Bean`注释。Spring对 标记`@Bean`方法只调用一次，因此返回的Bean也是单例。
```
@Configuration
@ComponentScan
public class AppConfig{
    @Bean
    ZoneId createZoneId() {
        return ZoneId.of("Z");
    }
}
```

#### 初始化和销毁

通常对Bean使用`init()`进行初始化，`shutdown()`进行清理。
```
@Component 
public class MailService {
    @PostConstruct
    public void init() {}
    @PreDestroy
    public void shutdown() {}
}
```

Spring容器对Bean初始化流程：
- 调用构造方法创建实例
- 根据`@Autowired`进行注入
- 调用标记`@PostConstruct`的`init()`方法进行初始化
- 销毁时，使用标记`@PreDestroy`的`shutdown()`方法


#### 使用别名

默认情况下，一种类型的Bean，Spring容器只能创建一个实例，但是有些时候我们需要对同一个类型的Bean创建多个实例。这时候Spring会报错，`NoUniqueBeanDefinitionException`异常。这时候可以使用
```
@Bean("name") 
//或者,指定别名
@Bean
@Qualifier("name") 
```
如果注入的时候没有指定Bean的名字，Spring会注入标记有`Primary`的Bean，相当于默认的Bean。


#### 使用FactoryBean


### 使用Resource
Spring提供`org.springframework.core.io.Resource`,可以像`Sring`，`int`一样使用`@Value`注入，
```
@Value("classpath:/logo.txt")
private Resource resource;
```
`classpath:/logo.txt`表示在classpath中搜索`logo.txt`文件，也可以直接指定路径"file:/path/to/logo.txt"

### 注入配置


### 使用条件装配


## 使用AOP


## 访问数据库


## 开发Web应用


## 集成第三方组件