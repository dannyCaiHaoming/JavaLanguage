package Lesson7;

public class Demo {
    public static void main(String[] args) {
        InnerDemo demo = new InnerDemo("String", 1);
        demo.log();
    }
}

abstract class Interface<T, K> {
    T a;
    K b;

    Interface(T a, K b) {
        this.a = a;
        this.b = b;
    }

    void log() {
        System.out.println(a);
        System.out.println("\n");
        System.out.println(b);
    }
}

/**
 * InnerDemo
 */
class InnerDemo extends Interface {

    InnerDemo(Object a, Object b) {
        super(a, b);
        // TODO Auto-generated constructor stub
    }

}