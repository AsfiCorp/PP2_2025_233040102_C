package id.ac.unpas.latihanmodul4ke2;

public class Persegi extends BangunDatar implements DapatDiwarnai {
    private double sisi;
    private String warna;

    public Persegi(double sisi, String warna) {
        this.sisi = sisi;
        this.warna = warna;
    }

    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }

    @Override
    public void warnai(String warnaBaru) {
        this.warna = warnaBaru;
        System.out.println("Persegi diwarnai " + warnaBaru);
    }

    public void tampilkanInfo() {
        System.out.println("Ini adalah Persegi, Warna: " + warna + ", Sisi: " + sisi);
        System.out.println("Luas: " + hitungLuas());
    }
}

