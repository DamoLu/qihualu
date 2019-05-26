package com.my.qihualu.thread;

/**
 * @Description: java类作用描述
 * @Author: luqihua
 * @CreateDate: 2019/5/26$ 23:27$
 */

//需求：等其它线程都采集完数据之后，再进行保存
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new JoinRunable("N1", 1000L));
        Thread t2 = new Thread(new JoinRunable("N2", 1500L));
        Thread t3 = new Thread(new JoinRunable("N3", 800L));

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join(); //join 方法主线程会等子线程执行完毕后再执行，子线程之间还是会并行执行

        System.out.println("save data");
    }

}

class JoinRunable implements Runnable {
    private String name;
    private long spendTime;
    public JoinRunable(String name, long spendTime) {
        this.name = name;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(name + "completed the task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}