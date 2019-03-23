package pl.mpas.advanced_programming.comparing;

import java.time.Year;

public class Car implements Comparable<Car> {

    private String brand;
    private String model;
    private String colour;
    private float capacity;
    private Year yearOfProduction;

    public Car(String brand, String model, String colour, float capacity, Year yearOfProduction) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.capacity = capacity;
        this.yearOfProduction = yearOfProduction;
    }

    public void maybeComparing(Comparable<Car> comparable) {
        System.out.println("inside maybeComparing()");
        System.out.println(comparable.compareTo(this));
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", capacity=" + capacity +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public float getCapacity() {
        return capacity;
    }

    public Year getYearOfProduction() {
        return yearOfProduction;
    }


    @Override
    public int compareTo(Car o) {
        // year comparision
        return yearOfProduction.compareTo(o.getYearOfProduction());
//        return this.yearOfProduction.getValue() - o.yearOfProduction.getValue();
    }
}
