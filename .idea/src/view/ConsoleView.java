package view;
import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;
public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }
    public int tampilkanMenu() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("   KNOWLEDGE MANAGEMENT SYSTEM - PUTUSAN NARKOTIKA");
        System.out.println("==================================================");
        System.out.println(" 1.  Tambah Putusan Baru");
        System.out.println(" 2.  Tampilkan Semua Putusan");
        System.out.println(" 3.  Cari Putusan (Nomor Perkara)");
        System.out.println(" 4.  Cari Putusan (Nama Terdakwa)");
        System.out.println(" 5.  Filter berdasarkan Jenis Narkotika");
        System.out.println(" 6.  Filter berdasarkan Pengadilan");
        System.out.println(" 7.  Filter berdasarkan Rentang Vonis (bulan)");
        System.out.println(" 8.  Hapus Putusan");
        System.out.println(" 9.  Tampilkan Statistik");
        System.out.println(" 10. Urutkan Data (Sort by Vonis / Denda)");
        System.out.println(" 11. Ekspor Statistik ke File (.txt)");
        System.out.println(" 0.  Keluar");
        System.out.println("==================================================");
        return InputHandler.validasiPilihan("Pilih menu (0-11): ", 0, 11, scanner);
    }
    public void tampilkanDaftarPutusan(ArrayList<Putusan> list) {
        if (list == null || list.isEmpty()) {
            tampilkanPesan("Tidak ada data putusan untuk ditampilkan.");
            return;
        }

        int lNomor    = "NOMOR PERKARA".length();
        int lPgdl     = "PENGADILAN".length();
        int lNama     = "NAMA TERDAKWA".length();
        int lJenis    = "JENIS".length();
        int lVonis    = "VONIS".length();
        int lKategori = "KATEGORI".length();

        for (Putusan p : list) {
            lNomor    = Math.max(lNomor,    safe(p.getNomorPerkara()).length());
            lPgdl     = Math.max(lPgdl,     safe(p.getPengadilan()).length());
            lNama     = Math.max(lNama,     safe(p.getNamaTerdakwa()).length());
            lJenis    = Math.max(lJenis,    safe(p.getJenisNarkotika()).length());
            lVonis    = Math.max(lVonis,    (p.getVonisHukuman() + " bln").length());
            lKategori = Math.max(lKategori, safe(p.getKategoriHukuman()).length());
        }

        String format = "%-" + lNomor + "s | %-" + lPgdl + "s | %-" + lNama +
                "s | %-" + lJenis + "s | %-" + lVonis + "s | %-" + lKategori + "s%n";
        int totalLebar = lNomor + lPgdl + lNama + lJenis + lVonis + lKategori + 17;

        System.out.println();
        System.out.printf(format,
                "NOMOR PERKARA", "PENGADILAN", "NAMA TERDAKWA",
                "JENIS", "VONIS", "KATEGORI");
        System.out.println("-".repeat(totalLebar));
        for (Putusan p : list) {
            System.out.printf(format,
                    safe(p.getNomorPerkara()),
                    safe(p.getPengadilan()),
                    safe(p.getNamaTerdakwa()),
                    safe(p.getJenisNarkotika()),
                    p.getVonisHukuman() + " bln",
                    safe(p.getKategoriHukuman()));
        }
        System.out.println("-".repeat(totalLebar));
        System.out.printf("Total ditampilkan: %d putusan.%n", list.size());
    }

    private String safe(String s) {
        return s == null ? "" : s;
    }

    public void tampilkanDetail(Putusan p) {
        if (p == null) {
            tampilkanPesan("Data putusan tidak ditemukan.");
            return;
        }
        p.tampilkan(true);
    }

    public void tampilkanStatistik(StatistikPutusan stat) {
        if (stat == null) {
            tampilkanPesan("Statistik tidak tersedia.");
            return;
        }
        stat.tampilkanLaporan();
    }
    public void tampilkanPesan(String pesan) {
        System.out.println(">> " + pesan);
    }

    public String[] inputFormPutusan(Scanner sc) {
        System.out.println();
        System.out.println("---- FORM TAMBAH PUTUSAN BARU ----");
        String nomorPerkara = InputHandler.validasiString("Nomor Perkara       : ", sc);
        String pengadilan = InputHandler.validasiString("Nama Pengadilan     : ", sc);
        String tanggal = InputHandler.validasiString("Tanggal Putusan     : ", sc);
        String namaTerdakwa = InputHandler.validasiString("Nama Terdakwa       : ", sc);
        int umur = InputHandler.validasiIntMinimal("Umur Terdakwa       : ", sc, 0);
        String jenisNarkotika = InputHandler.validasiString("Jenis Narkotika     : ", sc);
        double berat = InputHandler.validasiDoubleMinimal("Berat Barang Bukti (gram): ", sc, 0);
        String pasal = InputHandler.validasiString("Pasal Dilanggar     : ", sc);
        String peran = InputHandler.validasiString("Peran Terdakwa      : ", sc);
        int vonisHukuman = InputHandler.validasiIntMinimal("Vonis Hukuman (bulan): ", sc, 0);
        double vonisDenda = InputHandler.validasiDoubleMinimal("Vonis Denda (rupiah): ", sc, 0);
        String hakim = InputHandler.validasiString("Nama Hakim          : ", sc);

