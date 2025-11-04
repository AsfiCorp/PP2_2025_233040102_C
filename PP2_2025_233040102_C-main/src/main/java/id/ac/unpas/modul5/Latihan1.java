package id.ac.unpas.modul5;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Latihan1 {
    public static void main(String[] args) {
        /*
        Menjalankan code GUI di (EDT)
        implementasi paling baik dalam menghindari masalah thread
         */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //1.Objek JFrame
                JFrame frame = new JFrame("Jendela Orang Sunda");

                //2. Pengaturan Ukuran Jendela
                frame.setSize(400, 300);

                //3. Pengaturan tombol close (X) saat ditekan
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //4. Memperlihatkan jendela
                frame.setVisible(true);
            }
        });
    }
}
