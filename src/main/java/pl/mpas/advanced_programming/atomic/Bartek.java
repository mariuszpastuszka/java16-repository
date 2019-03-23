package pl.mpas.advanced_programming.atomic;

public class Bartek {
    static long increase = 0;

    public static void main(String[] args) {
        Runnable job = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                addSynchronized();              //   System.out.println("+++++++");
            }
        };
        Runnable jobNotSynchronized = () -> {
            long temp = 0;
            for (; ; ) {
                if (temp != increase) {
                    System.out.println(increase);
                    temp = increase;
                }
            }
        };
        Thread worker4 = new Thread(jobNotSynchronized);
        Thread worker1 = new Thread(job);
        Thread worker2 = new Thread(job);
        Thread worker3 = new Thread(job);
        worker4.start();
        worker1.start();
        worker2.start();
        worker3.start();
    }

    public static void addSynchronized() {
        long temp2 = increase;
        temp2++;
        synchronized (Bartek.class) {
            increase = temp2;
        }
    }
}
