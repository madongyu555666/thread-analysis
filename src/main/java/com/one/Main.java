package com.one;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    /**
     * 使用线程池优化
     * @param args
     */
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        Handle.send();
    }

}
