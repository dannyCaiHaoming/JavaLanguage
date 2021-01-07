## 集合

- `List`： 有序列表集合，数组
- `Set`: 无重复集合
- `Map`: 字典

### List

？？`Array`和`List`差别？？

- `ArrayList`: 普通数组，可以下标查找
- `LinkedList`: 链表，一个个查找

```
//用法
ArrayList list = new ArrayList(); // 没有泛型约束

// 都有泛型约束
List<int> intList = new ArrayList<>(); 
List<int> intList = new List<int>();
```


### 编写`equals()`方法

- `自反性`： 对于非`null`的`x`来说，`x.equals(x)`必须`true`
- `对称性`： 对于非`null`的`x``y`,必有`x.equals(y)`,`y.equals(x)`为真
- `传递性`： 对于非`null`的`x``y``z`,必有`x.equals(y)`,`y.equals(z)`,`x.equals(z)`为真
- `一致性`： 对于非`null`的`x`和`y`来说，只要`x`和`y`状态不变，则`x.equals(y)`总是一致地返回t`rue`或者`false`
- 对`null`的比较：即`x.equals(null)`永远返回`false`