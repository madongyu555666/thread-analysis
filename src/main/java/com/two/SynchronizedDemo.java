/*
package com.two;
*/
/*请分析以下程序的执行结果,并详细说明原因*//*

public class SynchronizedDemo implements Runnable{

    int x = 100;

    public synchronized void m1(String  m1) {
        x = 1000;
        try {
            System.out.println(m1);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x=" + x);
    }

    public synchronized void m2(String m2) {
        try {
            System.out.println(m2);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x = 2000;
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(()->sd.m1("m1")).start();
        new Thread(()->sd.m2("m2")).start();
        sd.m2("mian1");
        System.out.println("Main x=" + sd.x);

    }
    @Override
    public void run() {
        m1("main2");
    }
    */
/*
    * 1.共享：m1,m2，mian个线程同时竞争锁，又互斥（***********）
    *   m1,m2,两个方法都有synchronized修饰，当有线程获得锁的时候另一个线程等待获得锁线程执行完毕，又因为sleep不会释放锁，
    *   ，但是会释放cpu的资源，所以，m2执行后m1才会执行，或m1执行后m2才会执行，而mian在调用m2时，如果得到锁，会先m1,m2执行,结论是三个线程谁先得到锁就执行，
    *   另外的等待
    *
    * 2.小于<=1000
    * SynchronizedDemo2不是单例，而synchronized锁的是count，创建多个对象时，就不是同一把锁了，得不到1000的值
    *
    * *//*

}
*/
