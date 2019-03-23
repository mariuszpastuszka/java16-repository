package pl.mpas.advanced_programming.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercice2 {

    // 3 wątki zwiększają  zmienną typu long (500 iteracji)
    // wątek zwiększa zmienną co 500ms (w jobie)
    // wątki używają synchronizacji przy zapisie
    // jeden wątek wypisuje (bez synchronizacji) - cały czas
    // obserwujemy wyjście i sprawdzamy czy wypis zgadza się z zapisem
    // do zmiennej

    volatile static long counter = 0;

    public static void main(String[] args) {
        Runnable increaseJob = () -> {
            long currentCounterValue;
            for (int i = 0; i < 500_000; i++) {

//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (Exercice2.class) {
                    currentCounterValue = ++counter;
                }

                System.out.println(String.format("Current value: [%10d], from thred: [%s]",
                        currentCounterValue, Thread.currentThread().getName()));
            }
        };

        Runnable showJob = () -> {
            long temp =0;
            while (true) {

//                if (temp != counter) {
//                    System.out.println(counter);
//                    temp = counter;
//                }
                System.out.println("Value: [" + counter + "]");
            }



        };

        ExecutorService workers = Executors.newFixedThreadPool(4);
        workers.execute(showJob);
        workers.execute(increaseJob);
        workers.execute(increaseJob);
        workers.execute(increaseJob);


    }
}
