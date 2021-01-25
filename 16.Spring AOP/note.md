# AOP


## 静态代理，动态代理cglig代理

### 静态代理
介绍：这种代理方式需要代理对象和目标对象实现一样的接口
优点：可以在不修改目标对象的前提下扩展目标对象的功能

```
public interface UserInteface {
    public void save();
}

public class UserImpl implements UserInterface {
    @Override
    public void save(){
        System.out.printf("i am user");
    }
}

public class UserProxy implements UserInterface {
    private UserInterface target;
    public UserProxy(UserInterface target){
        this.target = target;
    }
    @Override
    public void save(){
        System.out.printf("proxy do");
        target.save();
    }

}
```

### 动态代理
介绍：动态代理利用`JDK API`，动态在内存中构建代理对象，从而实现对目标对象的代理功能。
动态代理对象不需要实现接口，但是要求目标对象必须实现接口。

#### 动态代理和静态代理区别
- 静态代理在编译时就已经实现，编译完成后代理类是一个实际的`class`文件
- 动态代理是运行时动态生成的，即编译完成后没有实际的文件`class`文件，而是运行时动态生成二进制文件（类字节码），并加载到JVM中



### cglib代理
全称(Code Generation Library)是一个第三方代码生成类库， 运行时在内存中动态生成一个子类对象，从而实现对目标对象功能的扩展。