package pl.mpas.advanced_programming.atomic;

public class Exercice5 {

    public static void main(String[] args) {
        Person mariusz = new Person("Mariusz", "P.", null);
        try {
            System.out.println("Before calling");
            synchronized (mariusz) {
                mariusz.wait(100000000);

//                Thread.sleep(100000000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end....");
    }
}
