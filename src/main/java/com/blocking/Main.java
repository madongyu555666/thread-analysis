package com.blocking;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    private static ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue(10);
    public static void main(String[] args) {
        for (int i = 1;i <= 100;i++)
        {
            new Thread(new Producer(i)).start();
        }

        for (int i = 1;i <= 100;i++)
        {
            new Thread(new Consumer()).start();
        }
    }




    public static class Producer implements Runnable{

        private  int i;


        public   Producer(int i){
            this.i=i;
        }
        @Override
        public void run() {
            try{
                queue.put(i);
                System.out.println("生产者" + Thread.currentThread().getName() + "生产：" + i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public static class Consumer implements Runnable{
        @Override
        public void run() {
            try{
                Integer take = queue.take();
                System.out.println("消费的值"+take);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
