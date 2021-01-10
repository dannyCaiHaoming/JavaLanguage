package Lesson8;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        // // 构造从start到end的序列：
        // final int start = 10;
        // final int end = 20;
        // List<Integer> list = new ArrayList<>();
        // for (int i = start; i <= end; i++) {
        // list.add(i);
        // }
        // // 随机删除List中的一个元素:
        // int removed = list.remove((int) (Math.random() * list.size()));
        // int result = findMissingNumber(10, 20, list);
        // System.out.println(result);

        // Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
        // public int compare(Student p1, Student p2) {
        // if (p1.score == p2.score) {
        // return 0;
        // }
        // return p1.score > p2.score ? -1 : 1;
        // }
        // });

        // map.put(new Student("name", 77), 1);
        // map.put(new Student("Bob", 66), 2);
        // map.put(new Student("Lily", 99), 3);

        // for (Student key : map.keySet()) {
        // System.out.println(key);
        // }
        // System.out.println(map.get(new Student("Bob", 66))); // null?

        // String f = "setting.properties";
        // Properties props = new Properties();
        // try {
        // // props.load(new java.io.FileInputStream(f));
        // props.load(Demo.class.getResourceAsStream("setting.properties"));

        // String filePath = props.getProperty("last_open_file");
        // } catch (Exception e) {
        // // TODO: handle exception
        // System.out.println(e);
        // }
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        int result = -1;
        for (int i = start; i <= end; i++) {
            if (!list.contains(i)) {
                result = i;
            }
        }
        return result;
    }

    public class Person {
        public String name;
        public int age;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Person) {
                Person p = (Person) obj;
                boolean equals = false;
                if (this.name == null && p.name == null) {
                    equals = true;
                }
                if (this.name != null) {
                    equals = this.name.equals(p.name);
                }
                return equals && this.age == p.age;
            }
            return false;
        }
    }

}

/**
 * InnerDemo
 */
class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return String.format("{%s: score = %d}}", name, score);
    }
}
