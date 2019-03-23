package pl.mpas.advanced_programming.generic.exercice;

import java.util.ArrayList;
import java.util.List;

public class VehicleExamle {

    public static void main(String[] args) {
        List<Plane> vehicles = new ArrayList<>();
        List<Vehicle> maybeCars = new ArrayList<>();

        VehicleProcessor.addNewCarIntoList(maybeCars);
        VehicleProcessor.displayVehicles(vehicles);
        VehicleProcessor.rawAdder(vehicles);

        Plane p = vehicles.get(0);
    }
}
