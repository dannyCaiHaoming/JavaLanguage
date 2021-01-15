package Lesson3;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * InnerDemo
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("Demo3 \n");

        // byte[] b1 = "Hello".getBytes();
        // try {
        //     byte[] b2 = "Hello".getBytes("UTF-8");
        //     System.out.println(b2 + "\n");
        // } catch (UnsupportedEncodingException e) {
        //     System.out.println(e + "\n");
        // }
        // System.out.println(b1);

    }

    Demo() {
        System.out.println("Demo init");
    }

    {
        System.out.println("objcect print --");
    }

    int price = 110;

    static {
        System.out.println("class print --");
    }

    static int amount = 112;

}

/*
 * Java中的String是一个引用类型，本身是一个class，但是内部是一个char[]数组。特点是不可修改
 */

/*
 * ASCII编码：
 */



 