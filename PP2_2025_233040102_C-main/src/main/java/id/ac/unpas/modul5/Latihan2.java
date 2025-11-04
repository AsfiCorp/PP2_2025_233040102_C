package id.ac.unpas.modul5;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Jendela Sunda Berlabel");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //1. Membuat JLabel
                JLabel label = new JLabel("Ini adalah JLabel.");

                //2. Menambahkan JLabel ke JFrame
                //Default Jlabel, menggunakan BorderLayout,
                // Kode .add() akan menambahkannya ke bagian tengah (CENTER)
                frame.add(label);

                frame.setVisible(true);
            }
        });
    }
}
