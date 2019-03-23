package pl.mpas.advanced_programming.comparing.ref_method;

import pl.mpas.advanced_programming.comparing.Car;

public class CompareByModel {

    public int orderByModel(Car first, Car second) {
        return
        first.getModel().compareTo(second.getModel());
    }
}
