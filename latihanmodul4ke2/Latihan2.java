package id.ac.unpas.latihanmodul4ke2;

// File: Latihan2.java
public class Latihan2 {
    public static void main(String[] args) {
        System.out.println("--- Info Bangun Datar (Polimorfisme) ---");

        // Polimorfisme: variabel BangunDatar bisa menampung Persegi dan Lingkaran
        BangunDatar bangun1 = new Persegi(5.0, "Hitam");
        BangunDatar bangun2 = new Lingkaran(3.0);

        // Tampilkan info Persegi
        ((Persegi) bangun1).tampilkanInfo();
        ((Persegi) bangun1).warnai("Merah");

        System.out.println("--------------------");

        // Tampilkan info Lingkaran
        ((Lingkaran) bangun2).tampilkanInfo();
        System.out.println("--------------------");
    }
}


