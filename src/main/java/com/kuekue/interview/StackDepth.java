package com.kuekue.interview;

public class StackDepth {

    static int i = 0;

    static void stackDepth() {
        System.out.println(i++);
        stackDepth();
    }

    public static void main(String[] args) {
        stackDepth();
    }

}
