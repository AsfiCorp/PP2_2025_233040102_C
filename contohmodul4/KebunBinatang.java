package id.ac.unpas.contohmodul4;

public class KebunBinatang {
    public static void main(String[] args) {
        Hewan[] daftarHewan = {
                new Kucing("Milo"),
                new Anjing("Rex"),
                new Burung("Tweety"),
                new Ikan("Nemo")
        };

        System.out.println("--- Demo Polimorfisme & Dynamic Dispatch ---");
        for (Hewan h : daftarHewan) {
            System.out.print(h.nama + ": ");
            h.bersuara();  // Dynamic Dispatch
        }

        System.out.println("\n--- Demo Interface ---");
        for (Hewan h : daftarHewan) {
            if (h instanceof BisaTerbang) ((BisaTerbang) h).terbang();
            if (h instanceof BisaBerenang) ((BisaBerenang) h).berenang();
        }
    }
}
