package id.ac.unpas.modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TugasModul07 extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    public TugasModul07() {
        setTitle("Aplikasi Manajemen Nilai Siswa (Tugas)");
        setSize(500, 450); // Tinggi ditambah sedikit agar tombol muat
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        add(tabbedPane);
    }

    private JPanel createInputPanel() {
        // [TUGAS 4] Ubah Layout jadi 5 baris agar muat tombol Reset
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia", "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(new JLabel(""));
        panel.add(btnSimpan);

        // [TUGAS 4] Tambahkan Tombol Reset
        JButton btnReset = new JButton("Reset Form");
        panel.add(new JLabel("")); // Placeholder agar tombol ada di kanan
        panel.add(btnReset);

        // Event Simpan
        btnSimpan.addActionListener(e -> prosesSimpan());

        // Event Reset
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
            txtNama.requestFocus();
        });

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // [TUGAS 2] Tambah Tombol Hapus di Bawah Tabel
        JButton btnHapus = new JButton("Hapus Data Terpilih");
        panel.add(btnHapus, BorderLayout.SOUTH);

        // Logika Hapus Baris
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cek baris mana yang diklik
                int selectedRow = tableData.getSelectedRow();

                if (selectedRow >= 0) {
                    // Jika ada baris yang dipilih, hapus
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                } else {
                    // Jika tidak ada baris yang dipilih (-1)
                    JOptionPane.showMessageDialog(null, "Pilih baris data yang ingin dihapus terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return panel;
    }

    private void prosesSimpan() {
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // [TUGAS 3] Validasi Nama minimal 3 karakter
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama harus minimal 3 karakter!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus 0-100!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // [TUGAS 1] Ubah logika Grade menjadi Switch Case
        // Trik: Gunakan pembagian integer. Contoh: 85 / 10 = 8.
        String grade;
        switch (nilai / 10) {
            case 10: // Nilai 100
            case 9:  // Nilai 90-99
            case 8:  // Nilai 80-89
                grade = "A";
                break;
            case 7:  // Nilai 70-79
                grade = "AB";
                break;
            case 6:  // Nilai 60-69
                grade = "B";
                break;
            case 5:  // Nilai 50-59
                grade = "BC";
                break;
            case 4:  // Nilai 40-49
                grade = "C";
                break;
            case 3:  // Nilai 30-39
                grade = "D";
                break;
            default: // Nilai 0-29
                grade = "E";
                break;
        }

        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TugasModul07().setVisible(true));
    }
}