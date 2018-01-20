package com.kuekue.interview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    static class MyThread implements Runnable {

        CyclicBarrier barrier;

        MyThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {

            System.out.println("my thread run... start" + Thread.currentThread().getName());
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("come... start" + Thread.currentThread().getName());

        }

    }

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

            @Override
            public void run() {
                System.out.println("起步跑?");
            }
        });

        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(barrier)).start();
        }

    }

}
