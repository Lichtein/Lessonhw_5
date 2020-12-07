package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class DownloadSimulation extends Thread {
    private Semaphore semaphore;

    private CountDownLatch cdl;

    public DownloadSimulation(String name, CountDownLatch cdl,Semaphore semaphore) {
        super(name);
        this.cdl = cdl;
        this.semaphore = semaphore;
    }


    public void run(){
        try {

            System.out.println("Download request has been sent");
            semaphore.acquire();
            System.out.println(this.getName() + " Download starts");
            sleep(850);
            System.out.println(this.getName() + " The download has been completed");
            semaphore.release();

            cdl.countDown();
            cdl.await();
        }catch (Exception e){


        }
    }
}
