package pl.mpas.advanced_programming;

@FunctionalInterface
interface SayHallo {
    void sayHallo();
    default void goodbye() {
        System.out.println("Goodbye!!!");
    }
}

@FunctionalInterface
interface Test {
    // int a, String name
    // 2 x default methods
    public abstract void doSomething(int a, String name);

    default void someMethod1() {
        System.out.println("someMethod1");
    }

    default void someMethod2() {
        System.out.println("someMethod2");
    }
}

public class HelloLambda {

    public static void main(String[] args) {
//        String a = "ala";
//        String b = "a" + "l" + "a";
//        String c = new String("ala");

        SayHallo hello = () -> {};
        hello.sayHallo();
        // use 2x
        // 1st wypisało: aa -- ss
        useTest((a, b) -> System.out.println("" + a + a + " -- " + b + b)
                , 5, "Mariusz");
        // 2nd wypisało: aaa --- sss
        useTest((int a, String c) -> System.out.println("" + a + a + a
        + " --- " + c + c +c), 10, ".");

        useTest(new Test() {
                    @Override
                    public void doSomething(int a, String name) {

                    }
                },
                5, "a");
    }

    static void useTest(Test test, int a, String s) {
        test.doSomething(a, s);
    }

    // TODO:
    // klasa implementuje Test
    // klasa anonimowa
    //
}
