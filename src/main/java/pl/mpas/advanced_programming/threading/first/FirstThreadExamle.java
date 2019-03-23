package pl.mpas.advanced_programming.threading.first;

public class FirstThreadExamle {

    public static void main(String[] args) {
        Runnable job = () -> {
            System.out.println("Worker: " +
                    Thread.currentThread().getName());
            System.out.println("Run Forest");
        };

        job.run();

        Thread worker = new Thread(job,
                "Pracuś");
//        worker.setName("Worker");
        worker.run();
        worker.start();
//        worker.start();
    }
}
