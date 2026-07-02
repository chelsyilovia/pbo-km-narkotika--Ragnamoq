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
}
