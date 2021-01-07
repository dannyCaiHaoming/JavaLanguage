package Lesson4;

public class Demo {
    public static void main(String[] args) {
        System.out.println("x");

        try {
            error1();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void error1() {
        try {
            error2();
        } catch (Exception e) {
            //TODO: handle exception
            throw new IllegalArgumentException(e);
        }
    }

    public static void error2() {
        throw new NullPointerException();
    }
}

/*   异常也是类结构，继承于Object??
     看声明，只看到`Throwable`接口是顶层
    
     `Error`   -------                  `Exception`
        |                           |                       |    
    `OutofMemoryError`       `RuntimeException`      `IOException`
                                    |   |
    错误一般不需要捕获，没救了。        `NullPointerException`    
                                    `IllegalArgumentException`


*/
