package com.cs.springbootesthirteen.test;

import org.junit.Test;

public class ThreadTest {


    @Test
    public void TestOne(){
        ThreadTest threadTest=new ThreadTest();
        //所有的这些启动方式的执行体都是在run方法中完成的
        threadTest.testLambda();
        threadTest.testRunnableWithAnonymousRunnable();
        threadTest.testRunnableWithAnonymousThread();
        threadTest.testRunnable();
        threadTest.testMyThread();
    }


    @Test
    public void testStartAndRun(){
        MyThread thread = new MyThread();
        thread.setName("MyThread");
//        thread.start();//start启动两者异步非阻塞运行
        thread.run();
        while (true){
            System.out.println("---- "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void testMyThread() {
        MyThread thread=new MyThread();
        thread.setName("MyThread");
        thread.start();
    }

    private void testRunnable() {//实现Runnablej接口
        MyRunnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
    }


    private void testRunnableWithAnonymousThread() {
        //匿名Runnable类开启线程
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("i am RunableWithAnoymous");
            };
        });
        thread.start();

    }

    private void testRunnableWithAnonymousRunnable() {//匿名Thread类开启线程
        new Thread(){
            @Override
            public  void  run(){
                System.out.println("i am ThreadWithAnoymous");
            }
        }.start();
    }

    private void testLambda() {//lambda表达式开启线程，jdk1.8中的特性
        new Thread(()-> System.out.println("i am lambda Thread....")).start();
    }

}
