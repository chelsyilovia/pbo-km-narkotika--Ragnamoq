package app;

import java.util.ArrayList;
import java.util.Scanner;
import controller.KnowledgeController;
import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import util.DataGenerator;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        KnowledgeRepository repository = new KnowledgeRepository();

        ArrayList<Putusan> dataSampel = DataGenerator.generateSampleData();
        for (Putusan p : dataSampel) {
            repository.simpan(p);
        }

        KnowledgeController controller = new KnowledgeController(repository);
        ConsoleView view = new ConsoleView();
        Scanner scanner = view.getScanner();

        view.tampilkanPesan("Selamat datang di KMS Putusan Pengadilan Narkotika.");
        view.tampilkanPesan(dataSampel.size() + " data sampel berhasil dimuat. Total objek Putusan dibuat: "
                + Putusan.getJumlahDibuat());

        boolean berjalan = true;
        while (berjalan) {
            int pilihan = view.tampilkanMenu();

            switch (pilihan) {
                case 1: {
                    String[] data = view.inputFormPutusan(scanner);
                    boolean sukses = controller.tambahPutusan(data);
                    view.tampilkanPesan(sukses
                            ? "Putusan berhasil ditambahkan."
                            : "Gagal menambahkan putusan. Periksa kembali data yang dimasukkan.");
                    break;
                }
                case 2: {
                    view.tampilkanDaftarPutusan(controller.tampilkanSemua());
                    break;
                }
                case 3: {
                    String nomor = util.InputHandler.validasiString("Masukkan Nomor Perkara: ", scanner);
                    ArrayList<Putusan> hasil = controller.cariPutusan(nomor, "nomor");
                    if (hasil.isEmpty()) {
                        view.tampilkanPesan("Putusan dengan nomor '" + nomor + "' tidak ditemukan.");
                    } else {
                        view.tampilkanDetail(hasil.get(0));
                    }
                    break;
                }
                case 4: {
                    String nama = util.InputHandler.validasiString("Masukkan Nama Terdakwa: ", scanner);
                    ArrayList<Putusan> hasil = controller.cariPutusan(nama, "nama");
                    view.tampilkanDaftarPutusan(hasil);
                    break;
                }
                case 5: {
                    String jenis = util.InputHandler.validasiString("Masukkan Jenis Narkotika: ", scanner);
                    view.tampilkanDaftarPutusan(controller.filterPutusan("jenis", jenis));
                    break;
                }
                case 6: {
                    String pengadilan = util.InputHandler.validasiString("Masukkan Nama Pengadilan: ", scanner);
                    view.tampilkanDaftarPutusan(controller.filterPutusan("pengadilan", pengadilan));
                    break;
                }
                case 7: {
                    int min = util.InputHandler.validasiIntMinimal("Vonis Minimal (bulan): ", scanner, 0);
                    int max = util.InputHandler.validasiIntMinimal("Vonis Maksimal (bulan): ", scanner, min);
                    view.tampilkanDaftarPutusan(controller.filterPutusan("vonis", min + "-" + max));
                    break;
                }
                case 8: {
                    String nomorHapus = util.InputHandler.validasiString("Masukkan Nomor Perkara yang dihapus: ", scanner);
                    boolean berhasilHapus = controller.hapusPutusan(nomorHapus);
                    view.tampilkanPesan(berhasilHapus
                            ? "Putusan berhasil dihapus."
                            : "Putusan tidak ditemukan, gagal menghapus.");
                    break;
                }
                case 9: {
                    StatistikPutusan stat = controller.getStatistik();
                    view.tampilkanStatistik(stat);
                    break;
                }
                case 10: {
                    System.out.println("1. Sort by Vonis (ascending)\n2. Sort by Denda (descending)");
                    int sub = util.InputHandler.validasiPilihan("Pilih metode sort (1-2): ", 1, 2, scanner);
                    if (sub == 1) {
                        controller.sortByVonis();
                    } else {
                        controller.sortByDenda();
                    }
                    view.tampilkanPesan("Data berhasil diurutkan.");
                    view.tampilkanDaftarPutusan(controller.tampilkanSemua());
                    break;
                }
                case 11: {
                    boolean eksporSukses = controller.eksporStatistik("statistik_putusan.txt");
                    view.tampilkanPesan(eksporSukses
                            ? "Statistik berhasil diekspor ke 'statistik_putusan.txt'."
                            : "Gagal mengekspor statistik.");
                    break;
                }
                case 0: {
                    berjalan = false;
                    view.tampilkanPesan("Terima kasih telah menggunakan KMS Putusan Narkotika. Sampai jumpa!");
                    break;
                }
                default:
                    view.tampilkanPesan("Pilihan tidak dikenali.");
            }
        }

        scanner.close();
    }
}