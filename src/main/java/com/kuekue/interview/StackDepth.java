package com.kuekue.interview;

/**
 * 测试栈深
 * 
 * @author lihao1
 *
 */

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
