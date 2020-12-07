package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3,true);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        UploadSimulation us = new UploadSimulation(countDownLatch1);
        us.start();
        try {
            us.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 11; i++) {
            new DownloadSimulation("Download "+i, countDownLatch,semaphore).start();

        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File have been deleted successfully ");

    }
}