package com.kuekue.interview;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 1000; i++) {
            stack.push(i++);
        }
    }

}
