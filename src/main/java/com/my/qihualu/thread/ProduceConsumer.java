package com.my.qihualu.thread;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/30$ 23:03$
 */
public class ProduceConsumer {
    private int i = 0;
    final private Object LOCK = new Object();
    private volatile boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            while (true) {
                if (isProduced) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    i++;
                    System.out.println("P-->" + i);
                    LOCK.notify();
                    isProduced = true;
                }
            }
        }
    }

    public void consumer() {
        synchronized (LOCK) {
            while (true) {
                if (isProduced) {
                    System.out.println("C-->" + i);
                    LOCK.notify();
                    isProduced = false;
                }else{
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumer pc = new ProduceConsumer();
        new Thread(pc::produce).start();
        new Thread(pc::consumer).start();
    }
}
