package Lesson1;
import java.util.Arrays;

// https://www.liaoxuefeng.com/wiki/1252599548343744/1259544070059520
// http://hollischuang.gitee.io/tobetopjavaer/#/basics/object-oriented/polymorphism

public class Demo {
    public static void main(String[] args) {
        // name();
        // Demo.name();
        for (String string : args) {
            System.out.println(string);
            if ("Danny".equals(string)) {
                System.out.println("I got you");
            }
        }
    }

    public static void name() {
        var a = 5;
        var b = 5.0;
        /*
         * 可直接使用var来定义基本变量，不需要完全像c一样，先声明变量类型。
         */
        var charA = 'A';
        var charB = 'B';

        char[] chars = { charA, charB };
        var string = new String(chars);

        System.out.println(string);

        char[] charsArray = new char[] { '1', '2' };
        int[] intArray = { 1, 2, 3, 4 };

        // System.out.println(charsArray);
        // System.out.println(intArray);
        // for (int i : intArray) {
        // System.out.println(i);
        // }
        System.out.println(Arrays.toString(intArray));

        for (int i = intArray.length - 1; i >= 0; i--) {
            System.out.println(intArray[i]);
        }

        int[][] doubleIntArray = { { 1, 3, 5 }, { 2, 4, 6 } };
        System.out.println(Arrays.deepToString(doubleIntArray));
    }

}