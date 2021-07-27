package com.study.thread.model;

public class CustomThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"");
    }
}
