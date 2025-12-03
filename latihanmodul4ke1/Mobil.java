package id.ac.unpas.latihanmodul4ke1;

public class Mobil extends Kendaraan {
        private int jumlahPintu;

        // Constructor
        public Mobil(String merk, int tahun, int jumlahPintu) {
            super(merk, tahun); // memanggil constructor Kendaraan
            this.jumlahPintu = jumlahPintu;
        }

        // Override method info
        @Override
        public void info() {
            System.out.println("Merk: " + merk + ", Tahun: " + tahun);
            System.out.println("Jumlah Pintu: " + jumlahPintu);
        }
}
