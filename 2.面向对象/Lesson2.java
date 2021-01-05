import java.util.Arrays;

/*
    1.是否是能有一个main函数，Vscode调试入口在哪里
    2.自定class怎么搞？  为啥加了public 之后，就需要用另外的文件定义？

*/

public class Lesson2 {
    public static void main(String[] args) {
        String[] demos = { "1", "2" };
        InnerDemo demo = new InnerDemo("des", 1, demos);

        // demo.setDemos(demos);
        // demo.setDes("des");
        // demo.setId(1);

        demo.log();
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
