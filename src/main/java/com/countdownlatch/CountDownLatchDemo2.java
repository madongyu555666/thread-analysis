package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author madongyu
 * @projectName thread-analysis
 * @description: 模拟高并发的场景
 * @date 2019/6/611:12
 */
public class CountDownLatchDemo2 implements  Runnable{
    static CountDownLatch countDownLatch=new CountDownLatch(1);

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(new CountDownLatchDemo2()).start();
        }
        countDownLatch.countDown();
    }


    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName:"+Thread.currentThread().getName());
    }
}
