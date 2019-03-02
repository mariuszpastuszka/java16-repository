package pl.mpas.advanced_programming.null_handling;

public class Chipset {

    private String vendorName;

    @Override
    public String toString() {
        return "Chipset{" +
                "vendorName='" + vendorName + '\'' +
                '}';
    }

    public Chipset(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }


}
