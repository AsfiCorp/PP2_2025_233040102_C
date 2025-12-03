package id.ac.unpas.contohmodul4;

public class Main {
    public static void main(String[] args) {
        Kucing anggora = new Kucing("Milo");
        Anjing herder = new Anjing("Rex");

        anggora.makan();
        anggora.bersuara();

        herder.makan();
        herder.bersuara();
    }
}
