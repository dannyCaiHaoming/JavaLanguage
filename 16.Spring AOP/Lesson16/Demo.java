package Lesson16;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        // System.out.printf("123");
        UserInterface user = UserImpl();
        UserInterface proxy = (UserInterface) new ProxyFactory(user).getProxyInstance();
        proxy.save();
    }

    
}

public interface UserInterface {
    public void save();
}

public class UserImpl implements UserInterface {
    @Override
    public void save(){
        System.out.printf("save");
    }
}

public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("提交事务");
                        return null;
                    }
                });
    }
}


