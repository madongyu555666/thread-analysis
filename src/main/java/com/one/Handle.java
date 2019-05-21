package com.one;

public class Handle {

    public static int send(){
        ThreadPool pool = ThreadPool.getInstance();
        Worker worker = new Worker();
        pool.addTask(worker);
        int capacity = pool.getRemainingCapacity();
        return capacity;

    }
}
