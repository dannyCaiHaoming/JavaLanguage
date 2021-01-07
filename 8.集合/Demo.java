import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int result = findMissingNumber(10, 20, list);
        System.out.println(result);
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
