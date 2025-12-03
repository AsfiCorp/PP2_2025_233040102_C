package id.ac.unpas.contohmodul4;

class Kucing extends id.ac.unpas.contohmodul4.Hewan {
    public Kucing(String nama) { super(nama); }

    @Override
    public void bersuara() {
        System.out.println(nama + " bersuara: Meong!");
    }
}
