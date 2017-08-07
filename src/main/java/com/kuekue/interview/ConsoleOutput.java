package com.kuekue.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ConsoleOutput {

    public static void outPut() {

        String t = "123";

        Vector<String> v = new Vector<>(5);
        v.add(t);

        System.out.println(v);

        t = "456";

        System.out.println(v);



        Integer i = 123;

        Vector<Integer> v2 = new Vector<>(5);
        v2.add(i);

        System.out.println(v2);

        i = 456;

        System.out.println(v2);

        StringBuilder sb = new StringBuilder();
        sb.append("123");

        Vector<StringBuilder> v3 = new Vector<>(5);
        v3.add(sb);

        System.out.println(v3);

        sb.append("456");

        System.out.println(v3);

        Map<String, String> map = new HashMap<String, String>();

        String k = "123";

        map.put("key", k);

        System.out.println(map.get("key"));

        k = "456";

        System.out.println(map.get("key"));


        Map<String, Integer> map2 = new HashMap<String, Integer>();

        Integer j = 123;

        map2.put("key", j);

        System.out.println(map2.get("key"));

        j = 456;

        System.out.println(map2.get("key"));

    }

    public static void main(String[] args) {
        outPut();
    }

}
