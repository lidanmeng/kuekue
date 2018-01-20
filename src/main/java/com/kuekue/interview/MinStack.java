package com.kuekue.interview;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stacl;

    private int min;

    public MinStack() {
        // do intialization if necessary
        this.stacl = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
    }

    /*
     * @param number: An integer
     * 
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stacl.push(number);
        min = min < number ? min : number;
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        return stacl.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        System.out.println(minStack.pop());
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
    }
}
