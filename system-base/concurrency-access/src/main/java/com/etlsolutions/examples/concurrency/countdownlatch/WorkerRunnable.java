package com.etlsolutions.examples.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author zc
 */
public class WorkerRunnable implements Runnable {

    private final CountDownLatch doneSignal;
    private final int i;

    
    WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
        doneSignal.countDown();
        System.out.println("down " + i);
    }
}
