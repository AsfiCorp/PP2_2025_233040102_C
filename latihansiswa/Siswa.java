package id.ac.unpas.latihansiswa;

public class Siswa {
    //Atribut
    String nama;
    String kelas;
    String nis;

    //Constructor
    public Siswa(String inputNama, String inputKelas, String inputNis) {
        this.nama = inputNama;
        this.kelas = inputKelas;
        this.nis = inputNis;
    }
    //Method infoSiswa()
    public void infoSiswa() {
        System.out.println("Nama : " + this.nama);
        System.out.println("Kelas : " + this.kelas);
        System.out.println("NIS : " + this.nis);
        System.out.println("-----------------------------");
    }
}
