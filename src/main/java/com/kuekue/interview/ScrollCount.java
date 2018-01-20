package com.kuekue.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ScrollCount {

    final static int LIMIT_COUNT = 3000;

    static Map<String, LinkedList<Long>> map = new HashMap<String, LinkedList<Long>>();

    static synchronized boolean isOver(String ip) {
        LinkedList<Long> list = map.get(ip);
        if (list == null) {
            list = new LinkedList<>();
            map.put(ip, list);
            list.add(System.currentTimeMillis());
            return 1 >= LIMIT_COUNT;
        }
        
        
        ListIterator<Long> it =  list.listIterator();
        while (it.hasNext()) {
            
        }
        int listSize = list.size();
        System.out.println(listSize);
        return listSize >= LIMIT_COUNT;
    }

    public static void main(String[] args) {

        int count = 10;

        final CountDownLatch countDown = new CountDownLatch(count);

        Executor service = Executors.newFixedThreadPool(count);

        for (int i = 0; i < count; i++) {
            service.execute(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        isOver("127.0.0.1");
                    }
                    countDown.countDown();
                }
            });
        }
        try {
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

}
