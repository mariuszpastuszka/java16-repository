package pl.mpas.advanced_programming.lambda_this;

public class Main {

    public void move() {
        System.out.println("move() inside main");
    }

    public Main() {

    }

    public Main(String name) {
        this.name = name;
    }

    private String name = "Main";

    public Moveable makeOne() {
        return new Moveable() {
            private String name = "Moveable";
            @Override
            public void move() {
                String name = "internal";
                System.out.println("inside anonymous class - move()");
                System.out.println("name = " + this.name);
                System.out.println(name);
                System.out.println("External name: " + Main.this.name);
                this.move();
            }
        };
    }

    public Moveable makeOneWithLambda() {
        String name = this.name;
        return () -> {
//            String name = "inside lambda";
            this.move();
            move();
            System.out.println(this.name);
        };
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

    }
}
