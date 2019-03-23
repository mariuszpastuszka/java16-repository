package pl.mpas.marek.exercice1;


import java.util.*;
import static pl.mpas.marek.exercice1.ListCreator.collectFrom;

//Stworzyć sparametryzowane interfejsy:
//        Selector - z metodą select, zwracającą true jesli argument spełnia warunek zapisany w metodzoe i false w przeciwnym razie
//        Mapper - z metodą map, będącą dowolną funkcją: argument -> wynik
//        oraz  sparametryzowaną klasę ListCreator, zawierającą:
//        statyczną metodę collectFrom (lista)
//        metodę when
//        metodę mapEvery
//        które działają w taki sposób, że symboliczny zapis:
//        collectFrom(list1).when(selektor).mapEvery(mapper)
//        spowoduje utworzenie listy wynikowej, której elementy stanowią wybrane przez selektor elementy listy list1, przekształacone za pomocą podanego mappera.
//        Działanie wyjasnia poniższy przykładowy program (którego plik może być modyfikowany tylko w meijscach oznaczonych przez /*<--    ....  */:


interface Selector<T> {
    boolean select(T o);
}

interface Mapper<A, R> {
    R map(A o);
}

class ListCreator<E> {
    private final List<E> list;

    private ListCreator(List<E> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<E> when(Selector<E> selector) {
        List<E> resultList = new ArrayList<>();

//        Iterator<E> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            E element = iterator.next();
//            if (selector.select(element)) {
//                resultList.add(element);
//            }
//        }

        for (E listElement : list) {
            if (selector.select(listElement)) {
                resultList.add(listElement);
            }
        }

        return new ListCreator<>(resultList);
    }
    public <R> List<R> mapEvery(Mapper<E, R> mapper) {
        List<R> resultList = new ArrayList<>();

        for (E element : list) {
            resultList.add(mapper.map(element));
        }
        return resultList;
    }
}

public class Main {
    public Main() {
        List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
        System.out.println(test1(src1));
//        List<Integer> src2 = Arrays.asList(-5, 71, 9, 11, 12);
//        System.out.println(test1(src2));

        List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
        System.out.println(test2(src2));
    }

    public List<Integer> test1(List<Integer> src) {
        Selector<Integer> sel = new Selector<Integer>() {
            @Override
            public boolean select(Integer number) {
                return number < 10;
            }
        };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
        Mapper<Integer, Integer> map = new Mapper<Integer, Integer>() {
            final int normalization = 10;
            @Override
            public Integer map(Integer number) {
                return number + normalization;
            }
        };   /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
        return   /*<-- zwrot wyniku
            uzyskanego przez wywołanie statycznej metody klasy ListCreator:
           */
                collectFrom(src).when(sel).mapEvery(map);
    }

    public List<Integer> test2(List<String> src) {
        Selector<String> sel = new Selector<String>() {
            final int minStringLen = 3;
            @Override
            public boolean select(String string) {
                return string.length() > minStringLen;
            }
        }; /*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */

        Mapper<String, Integer> map = new Mapper<String, Integer>() {
            final int normalization = 10;
            @Override
            public Integer map(String string) {
                return string.length() + 10;
            }
        };   /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
        return   /*<-- zwrot wyniku
            uzyskanego przez wywołanie statycznej metody klasy ListCreator:
           */  collectFrom(src).when(sel).mapEvery(map);
    }

    public static void main(String[] args) {
        new Main();
    }
}