package com.my.qihualu.thread;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/25$ 16:34$
 */
public class Daemon {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
           Thread innerThread = new Thread(()->{
               try {
                   while (true) {
                       System.out.println("do something for health check");
                       Thread.sleep(1_000);
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
           innerThread.setDaemon(true); //若不设置为守护线程，子线程会一直执行
           innerThread.start();
            try {
                Thread.sleep(1_000);
                System.out.println("t thread finish done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
