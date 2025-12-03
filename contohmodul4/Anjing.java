package id.ac.unpas.contohmodul4;

class Anjing extends id.ac.unpas.contohmodul4.Hewan {
    public Anjing(String nama) { super(nama); }

    @Override
    public void bersuara() {
        System.out.println(nama + " bersuara: Guk Guk!");
    }
}
