package pl.mpas.advanced_programming.null_handling_java8;

import java.util.Optional;

public class Example {

    public static void main(String[] args) {

        Computer fullOne = new Computer(new GraphicsCard(new Chipset("nVidia")));
        Computer withOutVendor = new Computer(new GraphicsCard(new Chipset(null)));
        Computer withoutChipset = new Computer(new GraphicsCard(null));
        Computer withoutGraphicsCard = new Computer(null);
        Computer maybeComputer = null;


    }

    public static String getVendorNameJava8Way(Computer computer) {

        return Optional.ofNullable(computer)
                .flatMap(computer1 -> computer1.getGraphicsCard())
                .flatMap(graphicsCard -> graphicsCard.getChipset())
                .map(chipset -> chipset.getVendorName())
                .orElseGet(() -> "brak");
    }

}
