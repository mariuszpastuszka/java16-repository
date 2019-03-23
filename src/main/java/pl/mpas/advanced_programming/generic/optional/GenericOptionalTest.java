package pl.mpas.advanced_programming.generic.optional;

import java.util.Optional;
import java.util.function.Predicate;

public class GenericOptionalTest {

    public static void main(String[] args) {
        Optional<String> maybeMyName = Optional.of("Mariusz");

        System.out.println(checkIfNameMatch("Mariusz", maybeMyName));
        System.out.println(checkIfNameMatch("Maniek", maybeMyName));
        System.out.println(null == null);
    }

    public static boolean checkIfNameMatch(String name, Optional<String> maybeName) {

        // filter
        Predicate<String> stringTest = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return name.equals(s);
            }
        };

        Predicate<CharSequence> charSequencePredicate = new Predicate<CharSequence>() {
            @Override
            public boolean test(CharSequence charSequence) {
                return name.equals(charSequence);
            }
        };
        System.out.println("Testing....");
        System.out.println("1st: " + maybeName.filter(stringTest));
        System.out.println("1st with char sequence: " + maybeName.filter(charSequencePredicate));

        System.out.println("1st: " + maybeName.filter(charSequencePredicate::test));
        System.out.println("1st with char sequence: " + maybeName.filter(charSequencePredicate));

        return maybeName.filter(s -> s.equals(name)).isPresent();
    }

    // result is option
    public static Object makeObject() {
        return null;
    }

    public static Optional<Object> makeSometimesObject() {
        return Optional.empty();
    }
}
