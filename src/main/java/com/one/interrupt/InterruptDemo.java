/*
package com.one.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            while (Thread.currentThread().isInterrupted()) {
                System.out.println("before:" + Thread.currentThread().isInterrupted())
                ;
                */
/*  i++;*//*

                Thread.interrupted();//对线程进行复位，由true 变成false
                */
/*System.out.println("num"+i);*//*

                System.out.println("after:" + Thread
                        .currentThread().isInterrupted());
            }

        }, "interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();//中断

        */
/*这种通过标识位或者中断操作的方式能够使线程在终止时
            有机会去清理资源，而不是武断地将线程停止，因此这种
            终止线程的做法显得更加安全和优雅。*//*

    }
}
*/
