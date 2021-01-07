package Lesson2;
import Lesson2.Outer.Inner;
import java.util.Arrays;


/*
    同个文件目录下，默认是同属于一个包，因此如果类名重复，就会出现错误。因此可以在文件头使用`package`解决名字冲突，修改文件完整名。
    例如当前类名，修改后是`Lesson2.Demo`；

    1.是否是能有一个main函数，Vscode调试入口在哪里
    2.自定class怎么搞？  为啥加了public 之后，就需要用另外的文件定义？
    3."找不到或无法加载主类"
    4.环境变量啥的`classpath`配置具体是怎么回事？
*/

public class Demo {
    public static void main(String[] args) {
        // String[] demos = { "1", "2" };
        // InnerDemo demo = new InnerDemo("des", 1, demos);

        // // demo.setDemos(demos);
        // // demo.setDes("des");
        // // demo.setId(1);

        // demo.log();

        // InnerLesson2 test = new InnerLesson2();
        // test.test();
        // test.test("test2");

        Outer outer = new Outer("Outer");
        outer.log();
        Inner inner = outer.new Inner();
        inner.change();
        outer.asyncLog();
    }

}

/**
 * InnerDemo
 */
class InnerDemo {
    private String desString;
    private int id;
    private String[] demos;

    public void setDemos(String... demos) {
        this.demos = demos;
    }

    public void setDes(String des) {
        this.desString = des;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void log() {
        System.out.println(this.desString);
        System.out.println(this.id);
        System.out.println(Arrays.deepToString(this.demos));
    }

    InnerDemo(String desString, int id, String[] demos) {
        this.desString = desString;
        this.id = id;
        this.demos = demos;

    }
}


/*
方法重载：  同名甚至一般同返回类型的函数，只是参数不一样，方便调用
*/
class InnerLesson2 {
    public void test(){
        System.out.println("test");
    }

    public void test(String string){
        System.out.println(string);
    }
    
}

/*
extends: 继承 扩展
protected: 可以让子类继承到，同时不对外，控制在`继承树`内
*/

class Person{
    int age;
    String name;

    void log(){
        System.out.print("Preson");
    }
}

class Student extends Person {
    Student(){
        super();
        System.out.println("Student init method");
    }
    @Override
    void log(){
        System.out.print("Student");
    }
}

/*
多态： 针对某个实例方法的调用，需要等到运行时才能决定具体使用哪个类型的方法。
*/
class Teacher extends Person{
    @Override
    void log(){
        System.out.print("Teacher");
    }
}

// public void runLog(Person p) {
//     p.log();
//     p.log();
// }


/*
抽象类(abstract)： 当实例方法顶层没有实际意义的时候，可使用抽象类。无法实例化，也无法执行。
*/


/*
接口(interface)： 比抽象类还要抽象，连字段都不带。
但是接口可以定义有静态字段的，但是需要使用`final`
*/

/*          抽象类                  接口
继承        只可extends一个     可implements多个接口
字段        可定义实例变量          不可
抽象方法        可                  可
非抽象方法      可                  可，default
*/


/*
类名查找路径：
当前package查找
从import包中查找
到java.lang查找
*/


/* 
内部类:
1.内部类不仅有个`this`指向自己，能能使用`Outer.this`指向外面的实例。
因此创建Inner实例的时候，也需要使用Outer.new

2.使用接口类初始化一个实例，但是必须要实现接口类定义的所有接口

3.使用static 修饰，就跟平时认知的内部类一样，可以使用`Outer.Inner`直接初始化，但是只能访问外部类的静态变量。
*/
class Outer {

    private String des;

    Outer(String des) {
        this.des = des;
    }

    class Inner {
        void change() {
            Outer.this.des = "Inner";
        } 
    }

    void log(){
        System.out.print(this.des);
    }

    void asyncLog() {
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("Hello" + Outer.this.des);
            }
        };
        new Thread(r).start();
    }
}

