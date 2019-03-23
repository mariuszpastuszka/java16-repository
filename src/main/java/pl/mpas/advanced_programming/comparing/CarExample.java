package pl.mpas.advanced_programming.comparing;

import pl.mpas.advanced_programming.comparing.ref_method.CompareByModel;
import pl.mpas.advanced_programming.comparing.ref_method.CompoundCarOrder;

import java.time.Year;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarExample {

    public static void main(String[] args) {
        List<Car> myCars = Arrays.asList(
                new Car("Saab", "93", "pink",
                        2500, Year.of(2000)),

                new Car("Saab", "95", "blue",
                        1800, Year.of(1995)),

                new Car("BMW", "MX5", "gray",
                        3000, Year.now())
        );

        System.out.println("before first sorting");
        System.out.println(myCars);

        System.out.println("after natural ordering");
        Collections.sort(myCars);
        System.out.println(myCars);

        Car carToCompare = new Car("Ford", "Focus", "blue",
                2000, Year.of(2010));
        carToCompare.maybeComparing((Car o) -> 1);

        System.out.println("After sorting by colour...");
        Collections.sort(myCars, new CarBrandComparator());
        System.out.println(myCars);

        myCars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return 0;
            }
        });


        myCars.sort((o1, o2) -> o1.getBrand().compareTo(o2.getBrand()));

        CompareByModel anotherModelComparingWay = new CompareByModel();

        myCars.sort((car1, car2) -> {
            return anotherModelComparingWay.orderByModel(car1, car2);
        });

        myCars.sort((car1, car2) -> anotherModelComparingWay.orderByModel(car1, car2));

        myCars.sort(anotherModelComparingWay::orderByModel);

        myCars.sort((o1, o2) -> CompoundCarOrder.orderByBrandNextByModelNextByYear(o1, o2));
        myCars.sort(CompoundCarOrder::orderByBrandNextByModelNextByYear);

        myCars.sort(Comparator.comparing(Car::getBrand).thenComparing(Car::getModel));
        // TODO: show casting
        myCars.sort(((Comparator<Car>)
                ((o1, o2) -> o1.getYearOfProduction().compareTo(o2.getYearOfProduction()))));


    }
}
