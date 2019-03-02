package pl.mpas.advanced_programming.null_handling;

import java.util.Optional;

public class Example {

    public static void main(String[] args) {

        Computer fullOne = new Computer(new GraphicsCard(new Chipset("nVidia")));
        Computer withOutVendor = new Computer(new GraphicsCard(new Chipset(null)));
        Computer withoutChipset = new Computer(new GraphicsCard(null));
        Computer withoutGraphicsCard = new Computer(null);
        Computer maybeComputer = null;

//        getVendorNameSuperNaiveImpl(withoutChipset);

        Optional<String> maybeMyName = Optional.ofNullable(null);

        if (maybeMyName.isPresent()) {
            System.out.println(maybeMyName.get());
        }

        maybeMyName.ifPresent(s -> System.out.println(s));
        maybeMyName.ifPresent(System.out::println);
    }

    public static String getVendorNameSuperNaiveImpl(Computer computer) {
        return computer.getGraphicsCard().getChipset().getVendorName();
    }

    public static String getVendorNameBetterOne(Computer computer) {
        String result = "unknown";
        try {
            result =computer.getGraphicsCard().getChipset().getVendorName();

        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        return result;
    }


    public static String getVendorNameSaveImpl(Computer computer) {
        String result = "unknown";

        if (null != computer) {
            result = "emtpy graphic card";
            GraphicsCard maybeCard = computer.getGraphicsCard();
            if (null != maybeCard) {
                Chipset maybeChipset  = maybeCard.getChipset();
                if (null != maybeChipset) {
                    String maybeVendorName = maybeChipset.getVendorName();
                    if (null != maybeVendorName) {
                        result = maybeVendorName;
                    }
                }
            }
        }

        return result;
    }

    public static Optional<String> getVendorNameJava8Way(Computer computer) {
        return Optional.ofNullable(computer)
                .map(computer1 -> computer1.getGraphicsCard())
                .map(graphicsCard -> graphicsCard.getChipset())
                .map(chipset -> chipset.getVendorName());

    }

    public static Optional<String> getVendorNameJava8WayShortWay(Computer computer) {
        return Optional.ofNullable(computer)
                .map(Computer::getGraphicsCard)
                .map(GraphicsCard::getChipset)
                .map(Chipset::getVendorName);

    }

//
//    public static String getGroovyWay(Computer computer) {
//        computer.?getGraphicsCard().?getChipset().?
//    }

}
