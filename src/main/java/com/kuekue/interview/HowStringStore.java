package com.kuekue.interview;

public class HowStringStore {

    public static void main(String[] args) {
        String str1 = new StringBuilder().append("abc").toString();
        String str2 = "abc";

        System.out.println(str1.intern() == str2);
    }
}
