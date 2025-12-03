package id.ac.unpas.latihanmodul4ke1;

public class Kendaraan {
    protected String merk;
    protected int tahun;

    // Constructor
    public Kendaraan(String merk, int tahun) {
        this.merk = merk;
        this.tahun = tahun;
    }

    // Method klakson
    public void klakson() {
        System.out.println("Tin Tin!");
    }

    // Method info (bisa di-override)
    public void info() {
        System.out.println("Merk: " + merk + ", Tahun: " + tahun);
    }
}
