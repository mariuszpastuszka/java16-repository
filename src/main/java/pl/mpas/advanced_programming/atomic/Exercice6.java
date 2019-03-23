package pl.mpas.advanced_programming.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Job implements Runnable {

    private String toPrint;
    private Object syncObject;

    public Job(String toPrint, Object syncObject) {
        this.toPrint = toPrint;
        this.syncObject = syncObject;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (syncObject) {
                System.out.println(toPrint);
                try {
                    syncObject.notify();
                    syncObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Exercice6 {

    public static void main(String[] args) {
        Object sync = new Object();
        Job tic = new Job("Tic", sync);
        Job toc = new Job("Toc", sync);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(tic);
        executorService.execute(toc);
    }
}
