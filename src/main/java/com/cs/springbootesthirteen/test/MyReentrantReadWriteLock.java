package com.cs.springbootesthirteen.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyReentrantReadWriteLock {
    private ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final MyReentrantReadWriteLock test=new MyReentrantReadWriteLock();
        new Thread(){
            public  void run(){
                test.get(Thread.currentThread());
                test.write(Thread.currentThread());
            }
        }.start();
        new Thread(){
            public  void  run(){
                test.get(Thread.currentThread());
                test.write(Thread.currentThread());
            }
        }.start();
    }

    private void write(Thread thread) {
        rwl.writeLock().lock();
        try {
            long start=System.currentTimeMillis();
            while (System.currentTimeMillis()-start<=1){
                System.out.println(thread.getName()+"正在进行写操作");
            }
            System.out.println(thread.getName()+"写操作完毕");
        } finally {
            rwl.writeLock().unlock();
        }
    }

    private void get(Thread thread) {
       try {
           rwl.readLock().lock();
           long start=System.currentTimeMillis();
           while (System.currentTimeMillis()-start<=1){
               System.out.println(thread.getName()+"正在进行读操作");
           }
           System.out.println(thread.getName()+"读操作完毕");
       } finally {
           rwl.readLock().unlock();
       }
    }
}
