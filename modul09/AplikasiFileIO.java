package id.ac.unpas.modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;

// --- LATIHAN 3: Class UserConfig ---
// Harus implements Serializable agar bisa disimpan sebagai Objek.
class UserConfig implements Serializable {
    private String username;
    private int fontSize;

    public UserConfig(String username, int fontSize) {
        this.username = username;
        this.fontSize = fontSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public String toString() {
        return "UserConfig{username='" + username + "', fontSize=" + fontSize + "}";
    }
}

// --- KELAS UTAMA ---
public class AplikasiFileIO extends JFrame {

    // Komponen UI
    private JTextArea textArea;
    private JTextField txtUsername; // Tambahan untuk Latihan 3 (Input Username)
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JButton btnAppendText; // Tambahan untuk Latihan 4
    private JButton btnSaveObject, btnLoadObject; // Tambahan untuk Latihan 3
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(800, 500); // Ukuran diperlebar sedikit agar tombol muat
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi Komponen Dasar
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        // --- Layout Bagian Atas (Input Username untuk Latihan 3) ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Ngaranna:"));
        txtUsername = new JTextField(20);
        topPanel.add(txtUsername);

        // --- Layout Bagian Bawah (Tombol-tombol) ---
        // Menggunakan GridLayout agar tombol tersusun rapi
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 5, 5));

        // Baris 1: Operasi Text (Latihan 1 & 4)
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan (Overwrite)");
        btnAppendText = new JButton("Simpan (Append)"); // Tombol Latihan 4

        // Baris 2: Operasi Binary & Object (Latihan 1 & 3)
        btnSaveBinary = new JButton("Simpan Bin (Font)");
        btnLoadBinary = new JButton("Muat Bin (Font)");
        btnSaveObject = new JButton("Simpan Obj (User)"); // Tombol Latihan 3
        btnLoadObject = new JButton("Muat Obj (User)");   // Tombol Latihan 3

        // Menambahkan tombol ke panel
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAppendText);
        buttonPanel.add(new JLabel()); // Spacer kosong

        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        buttonPanel.add(btnSaveObject);
        buttonPanel.add(btnLoadObject);

        // Menambahkan panel ke Frame
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Event Handling ---

        // Event Latihan 1 (Text Stream)
        btnOpenText.addActionListener(e -> bukaFileTeks());
        btnSaveText.addActionListener(e -> simpanFileTeks());

        // Event Latihan 1 (Binary Stream - Config Font saja)
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());

        // Event Latihan 4 (Append Text)
        btnAppendText.addActionListener(e -> simpanFileTeksAppend());

        // Event Latihan 3 (Object Serialization - UserConfig)
        btnSaveObject.addActionListener(e -> simpanUserConfig());
        btnLoadObject.addActionListener(e -> muatUserConfig());

        // Latihan 2: Baca file last_notes.txt saat aplikasi mulai
        bacaLastNotes();
    }

    // --- LOGIKA LATIHAN 4: Append Text ---
    private void simpanFileTeksAppend() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Konstruktor FileWriter(file, true) digunakan untuk mode APPEND
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(textArea.getText());
                writer.newLine(); // Tambahkan baris baru pemisah
                JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan (Append)!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal append file: " + ex.getMessage());
            }
        }
    }

    // --- LOGIKA LATIHAN 3: Object Serialization ---
    private void simpanUserConfig() {
        String username = txtUsername.getText();
        int fontSize = textArea.getFont().getSize();

        // Membuat objek UserConfig
        UserConfig config = new UserConfig(username, fontSize);

        // Menggunakan ObjectOutputStream untuk menyimpan objek
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.cfg"))) {
            oos.writeObject(config);
            JOptionPane.showMessageDialog(this, "Objek UserConfig berhasil disimpan!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan objek: " + ex.getMessage());
        }
    }

    private void muatUserConfig() {
        // Menggunakan ObjectInputStream untuk membaca objek
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.cfg"))) {
            // Casting objek yang dibaca kembali menjadi UserConfig
            UserConfig config = (UserConfig) ois.readObject();

            // Menerapkan data objek ke UI
            txtUsername.setText(config.getUsername());
            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontSize()));

            JOptionPane.showMessageDialog(this, "Objek dimuat: " + config.toString());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File user.cfg belum dibuat.");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat objek: " + ex.getMessage());
        }
    }

    // --- LOGIKA LAMA (LATIHAN 1 & 2) ---
    // (Tidak diubah, sesuai instruksi)

    private void bacaLastNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader("last_notes.txt"))) {
            String line;
            textArea.setText("");
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("last_notes.txt tidak ditemukan, memulai kosong.");
        }
    }

    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal: " + ex.getMessage());
            }
        }
    }

    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan (Overwrite)!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal: " + ex.getMessage());
            }
        }
    }

    private void simpanConfigBinary() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {
            int fontSize = textArea.getFont().getSize();
            dos.writeInt(fontSize);
            JOptionPane.showMessageDialog(this, "Font size disimpan ke config.bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal: " + ex.getMessage());
        }
    }

    private void muatConfigBinary() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
            int fontSize = dis.readInt();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
            JOptionPane.showMessageDialog(this, "Font size dimuat: " + fontSize);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}