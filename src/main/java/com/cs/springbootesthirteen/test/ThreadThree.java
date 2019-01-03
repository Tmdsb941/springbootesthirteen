package com.cs.springbootesthirteen.test;

public class ThreadThree {
    public static void main(String[] args) {
        Thread t1=new Thread(new RunIt());
        Thread t2=new Thread(new RunIt());
        t1.start();
        t2.start();
        t2.interrupt();
    }
}
