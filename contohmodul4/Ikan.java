package id.ac.unpas.contohmodul4;

class Ikan extends Hewan implements BisaBerenang {
    public Ikan(String nama) { super(nama); }

    @Override
    public void bersuara() { System.out.println(nama + " bersuara: Blub..."); }

    @Override
    public void berenang() { System.out.println(nama + " sedang berenang lincah!"); }
}
