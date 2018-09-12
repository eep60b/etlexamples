package com.etlsolutions.examples.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author zc
 */
public class WorkManager {

    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        CountDownLatch doneSignal = new CountDownLatch(N);
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < N; ++i) {
            // create and start threads
            executor.execute(new WorkerRunnable(doneSignal, i));
        }

        doneSignal.await();

        System.out.println("All Done");
        executor.shutdown();
    }
}
