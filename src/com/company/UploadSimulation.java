package com.company;

import java.util.concurrent.CountDownLatch;


public class UploadSimulation extends Thread {

    private CountDownLatch cld;

    public UploadSimulation(CountDownLatch cld) {
        this.cld = cld;

    }

    public void run() {
        try {
            for (int i = 0; i < 12 ; i++) {

                System.out.print("■");
                sleep(1200);
            }
            System.out.println("\nFile has been upload on the server");
            cld.countDown();
        } catch (Exception e){

        }

    }


}
