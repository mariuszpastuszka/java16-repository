package pl.mpas.marek.exercice3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Lista destynacji: port_wylotu port_przylotu cena_EUR
        List<String> dest = Arrays.asList(
                "bleble bleble 2000",
                "WAW HAV 1200",
                "xxx yyy 789",
                "WAW DPS 2000",
                "WAW HKT 1000"
        );
        double ratePLNvsEUR = 4.30;
//        List<String> result =
//                dest.stream()
//                        .filter(s -> s.startsWith("WAW"))
//                        .map(s -> s.split(" +"))
//                        .map(strings ->
//                                String.format("to %s - price in PLN:\t%d",
//                                        strings[1],
//                                        (int) (Integer.parseInt(strings[2]) * ratePLNvsEUR))
//                        )
//                        .collect(Collectors.toList());

        List<String> result =
                dest.stream()
                        .filter(s -> s.startsWith("WAW"))
                        .map(s -> {
                            String[] tokens = s.split(" +");
                            return String.format("to %s - price in PLN:\t%d",
                                    tokens[1],
                                    (int) (Integer.parseInt(tokens[2]) * ratePLNvsEUR));
                        })
                        .collect(Collectors.toList());
        /*<-- tu należy dopisać fragment
         * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
         * ani też żadnych własnych interfejsów
         */

        for (String r : result) System.out.println(r);
    }
}
