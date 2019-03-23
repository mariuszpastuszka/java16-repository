package pl.mpas.advanced_programming.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercice1 {

    // # użyj AtomicInteger
    // # 3 wątki - każdy zwiększa 100 x o 1 atomica (używamy incrementAndGet)
    // * busy waiting - ile razy nie udało się...
    // wątek main czeka na zakończenie obliczeń (ExecutorService)
    // wypisuje wynik

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        Runnable job = () -> {
            for (int i = 0; i < 10; i++) {
                int tmp = counter.incrementAndGet(); // ++counter

                System.out.println("Run by: " + Thread.currentThread().getName() + ", current atomic value: " + tmp);
            }
        };

        ExecutorService workers = Executors.newFixedThreadPool(3);

        workers.execute(job);
        workers.execute(job);
        workers.execute(job);

        workers.shutdown();

        boolean done = false;
        do {
            try {
                done = workers.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!done);


        System.out.println("Value from main: " + counter);

    }
}
