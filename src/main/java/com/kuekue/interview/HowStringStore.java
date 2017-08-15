package com.kuekue.interview;

public class HowStringStore {

    public static void main(String[] args) {
        String str1 = new StringBuilder().append("abc").toString();
        String str2 = "abc";
        String str3 = new String("abc");

        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
    }
}
