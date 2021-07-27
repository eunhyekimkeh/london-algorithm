package com.study.thread;

import com.study.thread.model.CustomThread;
import com.study.thread.model.SummingThread;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadMain {

    public static void main(String[] strs){

//        threadTest1();
//        threadTest2();
        threadTest3();


        // 실행순서 0,5,3,2,4,1 / 1,5,4,2,3,0
        // Q. start , run 차이
        // run은 로직을 한번 실행하지 thread 객체를 생성하지 않는다

        // thread.join -> 호출된 스레드가  완료될때까지 해당 스레드를 재호출하지 않는다


    }

    private static void threadTest1(){
        Thread thread1 = new Thread(new CustomThread());
        Thread thread2 = new Thread(new CustomThread());
        Thread thread3 = new Thread(new CustomThread());
        Thread thread4 = new Thread(new CustomThread());
        Thread thread5 = new Thread(new CustomThread());
        Thread thread6 = new Thread(new CustomThread());

        for(int i=0; i<5;i++){
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
        }

        System.out.println("");
        System.out.println("End of Main threadTest1");
    }

    private static void threadTest2(){
        Thread thread1 = new Thread(new CustomThread());
        Thread thread2 = new Thread(new CustomThread());
        Thread thread3 = new Thread(new CustomThread());
        Thread thread4 = new Thread(new CustomThread());
        Thread thread5 = new Thread(new CustomThread());
        Thread thread6 = new Thread(new CustomThread());

        try{
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();

            thread4.start();
            thread4.join();

            thread5.start();
            thread5.join();

            thread6.start();
            thread6.join();


        }catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("");
        System.out.println("End of Main threadTest2");
    }

    private static void threadTest3() {
        LocalDateTime startTime = LocalDateTime.now();
//        long sum = 0;
//        for(int i=0; i< 2000000000; i++){
//            sum+= i;
//        }

        SummingThread.sum =0;
        int threadCount = 4;
        int target = 2000000000;
        SummingThread[] threads = new SummingThread[threadCount];
        for(int i=0; i< threads.length; i++){
            threads[i] = new SummingThread(i*(target/threadCount), (i+1)*(target/threadCount)-1);
            threads[i].start();
        }
        for(int i=0; i< threads.length; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LocalDateTime endTime = LocalDateTime.now();

        System.out.println("Sum :"+SummingThread.sum);
        System.out.println("Time :" + ChronoUnit.MILLIS.between(startTime, endTime)+"ms");
    }
}
