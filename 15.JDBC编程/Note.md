# JDBC 编程简介

## 关系数据库

一般使用`mySQL`，全称`my structure quest language`。

## JDBC

全称`Java DataBase connectivity`。是`java`程序访问数据库的标准接口。

使用Java程序访问数据库时，Java代码并不是直接通过TCP链接访问数据库，而是通过JDBC接口访问，而JDBC接口则通过JDBC驱动来实现真正对数据库的访问。

我们能使用的部分是`JDBC`的接口部分，等于在Java程序控制数据库的过程中，我们只需要管`JDBC`的api代码，而不需要管背后`JDBC`如何跟数据库进行交互。而背后`JDBC`操作数据的部分，我们需要引入该厂商提供的`JDBC`驱动。这样的好处是，同一套上层的`JDBC`api代码，可以随意切换底层不同的数据库。

实际上，一个`MySQL`的`JDBC`驱动就是一个jar包，本身也是java编写的。我们自己编写的代码只需要引入java标准的`java.sql`包下的相关接口，由此再间接的通过`MySQL`驱动的jar包通过网络访问MySQL服务器，所有复杂的网络铜须都被封装到JDBC驱动中。



# JDBC 查询

步骤：
- 使用`Maven`添加`mysql-connector-java`的依赖
- 创建`JDBC`连接
- 创建查询语句，注意`SQL注入`问题
- 读取`ResultSet`的`next()`结果，获取每个查询结果

```
try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDEC_PWD)) {
    try (Statement stmt = conn.createStatement()) {
        try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
            while (rs.next()) {

            }
        }
    }
}
```

`SQL注入`：由于上面的`Statement`执行查询的时候，传入的是`String`，因此有两种做法
- 直接字符串拼接
```
User login(String name, String pass) {
    ...
    stmt.executeQuery("SELECT * FROM user WHERE login='" + name + "' AND pass='" + pass + "'");
    ...
}
```
- 使用`PreparedStatement`，且通过`setObject(index,object)`赋值
```
User login(String name, String pass) {
    ...
    String sql = "SELECT * FROM user WHERE login=? AND pass=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, name);
    ps.setObject(2, pass);
    ...
}
```

## JDBC更新


## JDBC事务

