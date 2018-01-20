package com.kuekue.interview;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    Executor threadPool = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

}
