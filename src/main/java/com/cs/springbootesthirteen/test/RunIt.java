package com.cs.springbootesthirteen.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunIt implements Runnable {
    private  static Lock lock=new ReentrantLock();
        @Override
        public void run () {

            try {
                //----------------------a
                lock.lock();
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + " running");
                TimeUnit.SECONDS.sleep(5);
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " finishend");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }

    }
