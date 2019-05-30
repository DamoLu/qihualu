package com.my.qihualu.thread;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/29$ 22:45$
 *
 * 验证this锁的存在，m1,m2方法上同时加synchornize, cpu 抢到任一个方法，必须
 * 等10秒才会释放锁，另一个方法才有机会执行
 */
public class SynchornizeThis {

    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread("T1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
    }

}

class ThisLock{

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}