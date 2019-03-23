package pl.mpas.advanced_programming.generic.exercice;

import java.util.List;

public class VehicleProcessor {

    static void displayVehicles(List<? extends Vehicle> vehicles) {
        vehicles.forEach(System.out::println);
        vehicles.forEach(x -> System.out.println(x));
    }

    static void addNewCarIntoList(List<? super Vehicle> vehicles) {
        vehicles.add(new Car());
        vehicles.add(new Vehicle() {
        });
    }

    static void rawAdder(List maybeCars) {
        maybeCars.add(new Car());
    }
}
