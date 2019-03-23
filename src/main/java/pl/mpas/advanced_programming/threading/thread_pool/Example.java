package pl.mpas.advanced_programming.threading.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {

    public static void main(String[] args) {

        Runnable job = () -> {
            System.out.println("Performed by: " + Thread.currentThread().getName());
        };

        ExecutorService workers = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 200; i++) {
            workers.execute(job);
        }
        workers.shutdown();

        System.out.println("after sending...");
    }
}
