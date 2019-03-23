package pl.mpas.advanced_programming.threading.second;

public class SecondThreadExample {

    public static void main(String[] args) {
        Thread.currentThread().setName("stachanow");
        System.out.println("main() - beginning...");
        Runnable job = () -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("Run by: " + Thread.currentThread().getName() +
                        ", iteration: " + (i + 1));
            }
        };
        // wypisz 10x napis
        // worker
        Thread worker1 = new Thread(job, "Stefan");
        worker1.setDaemon(true);
        Thread worker2 = new Thread(job, "Janusz");
        worker2.setDaemon(true);
//        worker1.run();
        System.out.println("main?? : " + Thread.currentThread().getName());
        worker1.start();
        System.out.println("inside main");
        worker2.start();
        // main wypisuje 3 x napis
        // obserwujemy wyjscie

        System.out.println("main() - end");
    }
}
