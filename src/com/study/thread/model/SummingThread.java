package com.study.thread.model;

public class SummingThread extends Thread{
    public static long sum;
    private int start;
    private int end;

    public SummingThread(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long temp = 0;
        for(int i=start; i<= end; i++){
            temp += i;
        }
        sum+= temp;
    }
}
