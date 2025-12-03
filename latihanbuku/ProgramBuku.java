package id.ac.unpas.latihanbuku;

public class ProgramBuku {
    public static void main(String[] args) {
        System.out.println("=== Sistem Perpustakaan ===");

        // Objek buku
        Buku bukuSaya = new Buku("Belajar Java OOP", "James Gosling", 250);
        // panggil getInfoBuku()
        bukuSaya.getInfoBuku();
        // Menggunakan getter untuk mengambil nilai int jumlah halaman
        System.out.println("Halaman : " + bukuSaya.getHalaman());
        System.out.println("-------------------------");

        // panggil setHalaman(300) -> Seharusnya Berhasil
        System.out.println("Mengubah halaman menjadi 300...");
        bukuSaya.setHalaman(300);
        System.out.println("Halaman sekarang: " + bukuSaya.getHalaman());

        // panggil setHalaman(-50) -> Seharusnya Error
        System.out.println("\nMengubah halaman menjadi -50...");
        bukuSaya.setHalaman(-50); // Akan memicu pesan error dari setter

        // Memastikan halaman tidak berubah (tetap 300)
        System.out.println("Halaman sekarang: " + bukuSaya.getHalaman());

        // Coba akses langsung (Uncomment baris di bawah untuk melihat error)
//         bukuSaya.jumlahHalaman = 100;

        /* Penjelasan Poin 10:
           Jika baris di atas dijalankan, akan muncul error:
           "jumlahHalaman has private access in Buku".
           Ini membuktikan Enkapsulasi berhasil melindungi data[cite: 283].
        */
    }
}