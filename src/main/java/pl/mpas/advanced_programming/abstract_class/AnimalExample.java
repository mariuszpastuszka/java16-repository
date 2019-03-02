package pl.mpas.advanced_programming.abstract_class;

public class AnimalExample {

    public static void main(String[] args) {
        // utwórz Zoo
        // użyj handleAnimal
        // wyślij 3 zwierzęta - w postaci klasy anonimowej
        Zoo myZoo = new Zoo();
        myZoo.handleAnimal(new Animal("Azor") {
            @Override
            public void eat() {
                System.out.println("Eating.....");
            }

            @Override
            public void play() {

            }
        });

        myZoo.handleAnimal(new Animal("Azor") {
            @Override
            public void eat() {
                System.out.println("Eating.....");
            }

            @Override
            public void play() {

            }
        });

        Animal maybeCat = null;
        new Animal("cat") {
            @Override
            public void eat() {

            }

            @Override
            public void play() {

            }

            public void miauuu() {

            }
        }.miauuu();

        Object o = "ala";
        ((String) o).length();
    }
}
