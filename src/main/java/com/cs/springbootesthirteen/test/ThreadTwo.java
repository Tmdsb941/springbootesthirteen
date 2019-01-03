package com.cs.springbootesthirteen.test;


import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadTwo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> futureTask=new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void testOne() throws InterruptedException, ExecutionException {
        ExecutorService threadPool=Executors.newSingleThreadScheduledExecutor();
        Future<Integer> future=threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });
        Thread.sleep(3000);
        System.out.println(future.get());
    }

    @Test
    public synchronized  void method1() throws ExecutionException, InterruptedException {
        method2();
    }

    private synchronized void method2() throws ExecutionException, InterruptedException {
        testOne();
    }
}
