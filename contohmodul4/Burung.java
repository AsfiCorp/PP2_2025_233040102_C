package id.ac.unpas.contohmodul4;

class Burung extends Hewan implements BisaTerbang {
    public Burung(String nama) { super(nama); }

    @Override
    public void bersuara() { System.out.println(nama + " bersuara: Cit Cit!"); }

    @Override
    public void terbang() { System.out.println(nama + " sedang terbang tinggi!"); }
}
