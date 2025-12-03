package id.ac.unpas.latihanbuku;

public class Buku {
    // Atribut
    String judul;
    String penulis;
    // Enkapsulapsi
    private int jumlahHalaman;

    // Constructor
    public Buku(String judul, String penulis, int jumlahHalaman) {
        this.judul = judul;
        this.penulis = penulis;
        // setter pra
        setHalaman(jumlahHalaman);
    }
    // M-Getter info buku
    public void getInfoBuku() {
        System.out.println("Judul  : " + this.judul);
        System.out.println("Penulis  : " + this.penulis);
    }
    // M-Getter halaman
    public int getHalaman() {
        return this.jumlahHalaman;
    }
    // M-Setter set halaman
    public void setHalaman(int halamanBaru) {
        if (halamanBaru > 0) {
            this.jumlahHalaman = halamanBaru;
        } else {
            System.out.println("Error: Jumlah halaman harus lebih dari 0!");
        }
    }
}
