## 泛型

### 为什么时候泛型
- 能够使用魔板代码来适应任意类型
- 使用时不需要进行了诶性强制转换，它通过编译器进行类型检查


### 泛型继承关系
- 向上转型


## 使用泛型

```
// 定义泛型接口
public interface Comparable<T>{
    int compareTo(T o);
}

```

```
// 实现泛型接口
class Person impletents Comparable<Person> {
    public int compareTo(Person other) {
        return 1;
    }
}
```

### 编写泛型
