package id.ac.unpas.latihansiswa;

public class ProgramSiswa {
        public static void main(String[] args) {
            System.out.println("=== Data Siswa ===");

            // Objek (Instansiasi)
            // Membuat siswa1 dengan data spesifik
            Siswa siswa1 = new Siswa("Budi Santoso", "10A", "12345");

            // Membuat siswa2 dengan data berbeda
            Siswa siswa2 = new Siswa("Siti Aminah", "11B", "67890");

            //Memanggil Method
            siswa1.infoSiswa();
            siswa2.infoSiswa();
        }
    }
