package com;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.set(1);
        int i = atomicInteger.get();
        System.out.println(i);

    }
}
