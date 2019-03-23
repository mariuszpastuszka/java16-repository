package pl.mpas.advanced_programming.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample {

    public static void main(String[] args) {
        // 2 x order
        // 3/4 x item
        // 2 or more ingredients
        // TODO: refactor to builder
        List<Item> saturdayItems = Arrays.asList(
                new Item("kino", BigDecimal.valueOf(35.00),
                        Arrays.asList(new Ingredient("paper"))),
                new Item("chlebek", BigDecimal.valueOf(15.00),
                        Arrays.asList(new Ingredient("sugar"), new Ingredient("H2O"))

                ));
        Order saturdayShopping = new Order(saturdayItems);

        List<Item> sundayItems = Arrays.asList(
                new Item("Cola", BigDecimal.valueOf(30.00),
                        Arrays.asList(new Ingredient("e52"), new Ingredient("uran")))
        );
        Order sundayShopping = new Order(sundayItems);

        System.out.println(getIngredientsNames(Arrays.asList(sundayShopping, saturdayShopping)));
        System.out.println("result: " + getIngredientsNamesWithReduce(Arrays.asList(sundayShopping, saturdayShopping)));
    }

    public static List<String> getIngredientsNamesWithReduce(List<Order> orders) {
//        IntStream.range(1, 100)

        List<String> result = new ArrayList<>();
        return orders.stream()
                .flatMap(order -> order.getMyItems().stream())
                .flatMap(item -> item.getIngredientsList().stream())
//                .map(ingredient -> ingredient.getName())
                .map(Ingredient::getName)
                .distinct()
                .reduce(result,
                        (strings, s) -> {
                            strings.add(s);
                            System.out.println(strings);
                            return strings;
                        },
                        (strings, strings2) -> {
                            strings.addAll(strings2);
                            return strings;
                        });

    }


    public static List<String> getIngredientsNames(List<Order> orders) {
//        IntStream.range(1, 100)
        return orders.stream()
                .flatMap(order -> order.getMyItems().stream())
                .flatMap(item -> item.getIngredientsList().stream())
//                .map(ingredient -> ingredient.getName())
                .map(Ingredient::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public static BigDecimal sumMyItems(List<Order> orders) {
//        IntStream.range(1, 100)
        return
                orders.stream()
                        .flatMap(order -> order.getMyItems().stream())
                        .map(item -> item.getPrice())
                        .reduce(BigDecimal.ZERO, (bigDecimal, bigDecimal2) -> bigDecimal.add(bigDecimal2));
    }

}
