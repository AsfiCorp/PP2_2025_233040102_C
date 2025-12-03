package id.ac.unpas.modul06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author wdgus
 */
public class LatihanKalkulator {
    public static void main(String[] args) {
        // 1. Frame Utama menggunakan BorderLayout
        JFrame frame = new JFrame("Calculator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // 2. Bagian Atas: Layar Tampilan (JTextField)
        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        // 3. Bagian Tengah: Tombol-tombol (Grid 4x4)
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4));

        // Daftar label tombol (0-9, operator, dan pelengkap agar jadi 16)
        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        // Loop untuk membuat dan menambahkan tombol ke panel
        for (String label : labels) {
            panelTombol.add(new JButton(label));
        }

        // Tambahkan panel tombol ke frame bagian tengah
        frame.add(panelTombol, BorderLayout.CENTER);

        // 4. Tampilkan
        frame.setVisible(true);
    }
}