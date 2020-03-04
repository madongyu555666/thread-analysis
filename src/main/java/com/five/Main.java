/*
package com.five;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
*/
/*当队列为空时，请求take会被阻塞，直到队列不为空

当队列满了以后，存储元素的线程需要备阻塞直到队列可以添加数据*//*

public class Main {

    List<String> list = new ArrayList<>(10);
    ReentrantLock lock=new ReentrantLock();
    Condition condition = lock.newCondition();
    public static void main(String[] args) {
        Main main=new Main();

        for (int i=0;i<100;i++){
            int start=i;
            new Thread(()->{
                main.put("第几个"+start);
            }).start();
        }

        for (int i=0;i<100;i++){
            int start=i;
            new Thread(()->{
                System.out.println(main.take());
            }).start();
        }
    }


    public  String  take(){
       try{
           lock.lock();
           while (list.size()==0){
               System.out.println("队列为空，等待数据，阻塞");
               condition.await();
           }

           String s=list.remove(0);
           condition.signalAll();
           return s;
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
       return null;
    }


    public  void put(String value){
        try{
           lock.lock();
           while (list.size()>=10){
               System.out.println("队列已满，阻塞");
               condition.await();
           }
            list.add(value);
           condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
*/
