package id.ac.unpas.contohmodul4;

abstract class Hewan {
    String nama;

    public Hewan(String nama) { this.nama = nama; }

    public void makan() {
        System.out.println(nama + " sedang makan.");
    }

    public abstract void bersuara();
}

//class Hewan {
//    String nama;
//
//    public Hewan(String nama) {
//        this.nama = nama;
//    }
//
//    public void makan() {
//        System.out.println(nama + " sedang makan.");
//    }
//
//    public void bersuara() {
//        System.out.println("Hewan ini bersuara...");
//    }
//}
