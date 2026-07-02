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