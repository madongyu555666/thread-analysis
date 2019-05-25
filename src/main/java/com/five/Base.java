package com.five;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private Lock lock = new ReentrantLock();
    private Condition takeCondition = lock.newCondition();
    private Condition putCondition = lock.newCondition();
    private List list = new ArrayList();
    private static final int MAX_VALUE = 10;

    public <E> E take(){

        lock.lock();
        try{
            while(list.size() == 0) {
                try {
                    takeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            E e = (E)list.remove(0);
            putCondition.signal();
            return e;

        }finally {
            lock.unlock();
        }
    }

    public <E> void put(E e){
        lock.lock();
        try{
            while (list.size() == MAX_VALUE){
                putCondition.await();
            }
            list.add(e);
            takeCondition.signal();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
