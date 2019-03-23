package pl.mpas.advanced_programming.threading.third;

// TODO: add loggers
public class Example {

    // main tworzy 2 obiekty Thread
    // każdy wątek tworzy 3 kolejne obiekty Thread (demony)
    // każdy demon wypisuje tekst 10 razy

    public static void main(String[] args) {
        Runnable deamonJob = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Run by: " + Thread.currentThread().getName() +
                        ", Iteration: " + (i + 1));
            }
        };

        Runnable spawnJob = () -> {
            for (int i = 0; i < 3; i++) {
                String daemonName = Thread.currentThread().getName() + "-" + "deamon-" + i;
                Thread newOne = new Thread(deamonJob, daemonName);
                newOne.setDaemon(true);
                newOne.start();
                try {
                    Thread.sleep(500); // janusz idz na piwo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread janusz = new Thread(spawnJob, "janusz");
        janusz.setPriority(Thread.MAX_PRIORITY);
        janusz.start();

        Thread andrzej = new Thread(spawnJob, "andrzej");
        andrzej.setPriority(Thread.MIN_PRIORITY);
        andrzej.start();
    }
}
