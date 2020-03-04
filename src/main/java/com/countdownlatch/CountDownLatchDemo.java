/*
package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

*/
/**
 * @author madongyu
 * @projectName thread-analysis
 * @description: TODO
 * @date 2019/6/611:05
 *//*

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);

        new Thread(()->{
            System.out.println(""+Thread.currentThread().getName()+"-执行中");
            countDownLatch.countDown();
            System.out.println(""+Thread.currentThread().getName()+"-执行完毕");
        },"i1").start();

        new Thread(()->{
            System.out.println(""+Thread.currentThread().getName()+"-执行中");
            countDownLatch.countDown();
            System.out.println(""+Thread.currentThread().getName()+"-执行完毕");
        },"i2").start();


        new Thread(()->{
            System.out.println(""+Thread.currentThread().getName()+"-执行中");
            countDownLatch.countDown();
            System.out.println(""+Thread.currentThread().getName()+"-执行完毕");
        },"i3").start();

        countDownLatch.await();
        System.out.println("所有线程执行完毕");
    }
}
*/
