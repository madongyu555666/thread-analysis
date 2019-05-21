package com.one.thread;

public class MyThread2 implements Runnable {


    @Override
    public void run() {
        System.out.println("vvv");
    }


    public static void main(String[] args) {
        MyThread2 myThread2=new MyThread2();
        new Thread(myThread2).start();
    }
}
