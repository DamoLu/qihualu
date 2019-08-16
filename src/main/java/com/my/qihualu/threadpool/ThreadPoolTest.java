package com.my.qihualu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luqihua
 * @title: ThreadPoolTest
 * @projectName qihualu
 * @description: TODO
 * @date 2019/8/13
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "is running....");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
