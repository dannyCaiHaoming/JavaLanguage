# 1.1.1 注解@RequestMapping

例如: `@RequestMapping("/hello")` 

当web请求为/hello时，跳转到这个class进行处理

可声明在`类型`上，也可声明在`方法`上<br>
类型上就为请求地址，方法上通常表情请求方法


# 1.1.2 注解@ReponseBody,@RequestBody

- @ResponseBody

表示该方法的返回结果直接写入到HTTP响应正文中

- @RequestBody

将参数插入到HTTP请求正文中    

# 1.1.3 注解@PathVariable,@RequestParam

- @PathVariable

获取请求路径中的变量作为参数

- @RequestParam

获取静态URL传入的参数