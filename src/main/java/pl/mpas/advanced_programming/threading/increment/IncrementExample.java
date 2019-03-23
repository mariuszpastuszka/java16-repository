package pl.mpas.advanced_programming.threading.increment;

class Job implements Runnable {
    // TODO: show with int
    volatile private int toIncrement = 0;
    private static int staticIncrement = 1;

    static public void incStatic() {
        ///
        Class<Job> jobsPlan = Job.class;
//        synchronized (Job.class) {
            staticIncrement++;
//        }
    }

    @Override
    public String toString() {
        return "toIncrement: " + toIncrement;
    }

    @Override
//    synchronized
    public void run() {

        for (int i = 0; i < 100_000; i++) {
            System.out.println("Increased by thread: " + Thread.currentThread().getName());
//            synchronized (this) {
                toIncrement++;
//            int a = 5 +  ++toIncrement;
//            int B = 5 +  toIncrement++;
//            }
        }
    }
}

public class IncrementExample {

    public static void main(String[] args) {
        Job job = new Job();

        Thread worker1 = new Thread(job, "janusz");
        Thread worker2 = new Thread(job, "andrzeju");
        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current job value: " + job);
    }

}
