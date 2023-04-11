package com.wcbeh.misc.pointers;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        withoutPointer();
        withPointer();
    }

    private static void withoutPointer() {
        System.out.println("------- Without Pointer -------");
        int a = 11;
        int b = a; // b is just initialize the value of a

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        a = 12;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private static void withPointer() {
        System.out.println("------- With Pointer -------");
        Map<String, String> a = new HashMap();
        Map<String, String> b = new HashMap();

        a.put("value", "11");
        b = a; // b is pointing to a
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        b.put("value", "22");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}
