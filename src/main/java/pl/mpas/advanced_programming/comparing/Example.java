package pl.mpas.advanced_programming.comparing;

import java.lang.reflect.Array;
import java.util.*;

public class Example {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("Mariusz", "P.", 20),
                new Person("Antoni", "W.", 20),
                new Person("Ola", "P.", 25)
        );

        Collections.sort(persons);

        Collections.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(persons, Comparator.comparing(Person::getSurname).
                thenComparing(Person::getName));
        // druga liter imienia
    }
}
