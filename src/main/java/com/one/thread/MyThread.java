package com.one.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("asd");
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
    }
}
