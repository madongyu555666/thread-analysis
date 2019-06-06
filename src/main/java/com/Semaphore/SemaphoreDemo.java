package com.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author madongyu
 * @projectName thread-analysis
 * @description: TODO
 * @date 2019/6/611:44
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for(int i=0;i<10;i++){
            new Car(i,semaphore).start();
        }
    }
    static class Car extends Thread{
        private int num;
        private Semaphore semaphore;
        public Car(int num, Semaphore
                semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获得一个许可
                System.out.println("第"+num+"占用 一个停车位");
                        TimeUnit.SECONDS.sleep(2);
                System.out.println("第"+num+"俩车 走喽");
                semaphore.release();//释放一个许可
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
