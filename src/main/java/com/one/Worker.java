package com.one;

public class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println("创建任务,发送信息");

    }
}
