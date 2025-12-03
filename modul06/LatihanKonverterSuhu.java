package id.ac.unpas.modul06;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author wdgus
 */
public class LatihanKonverterSuhu {
    public static void main(String[] args) {
        // 1. Frame Utama
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        // Menggunakan GridLayout agar komponen tersusun rapi ke bawah
        frame.setLayout(new GridLayout(5, 1));

        // 2. Komponen-komponen
        JLabel labelCelcius = new JLabel("Masukkan Suhu (Celcius):");
        JTextField textCelcius = new JTextField();
        JButton buttonKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Hasil dalam Fahrenheit:");
        JLabel labelHasil = new JLabel("..."); // Tempat output hasil

        // 3. Event Handling
        buttonKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textCelcius.getText();

                try {
                    // a. Ubah teks ke double
                    double c = Double.parseDouble(input);

                    // b. Hitung rumus: (celcius * 9/5) + 32
                    double f = (c * 9.0 / 5.0) + 32;

                    // c. Tampilkan hasil ke label
                    labelHasil.setText(String.valueOf(f));

                } catch (NumberFormatException error) {
                    // d. Penanganan error jika input bukan angka
                    JOptionPane.showMessageDialog(frame, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 4. Tambahkan komponen ke Frame
        frame.add(labelCelcius);
        frame.add(textCelcius);
        frame.add(buttonKonversi);
        frame.add(labelFahrenheit);
        frame.add(labelHasil);

        // 5. Tampilkan
        frame.setVisible(true);
    }
}