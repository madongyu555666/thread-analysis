package com.one.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "asd";
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        CallableDemo callableDemo=new CallableDemo();
        Future<String> submit = executorService.submit(callableDemo);
        System.out.println(submit.get());
        executorService.shutdown();
    }
}
