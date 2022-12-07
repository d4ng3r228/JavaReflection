package com.company;

public class Task {
    @MyAnn(a = 2, b = 3)
    public void test(Integer a, Integer b) {
        System.out.println("Result = " + a * b);
    }
}
