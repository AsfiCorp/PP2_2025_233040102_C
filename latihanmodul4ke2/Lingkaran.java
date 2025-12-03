package id.ac.unpas.latihanmodul4ke2;

public class Lingkaran extends BangunDatar {
    private double radius;

    public Lingkaran(double radius) {
        this.radius = radius;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * radius * radius;
    }

    public void tampilkanInfo() {
        System.out.println("Ini adalah Lingkaran, Radius: " + radius);
        System.out.println("Luas: " + hitungLuas());
    }
}
