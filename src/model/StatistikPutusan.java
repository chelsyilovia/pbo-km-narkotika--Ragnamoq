package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan {

    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiPeran;

    private final ArrayList<Putusan> daftar;

    public StatistikPutusan(ArrayList<Putusan> daftar) {
        this.daftar = daftar;
        this.distribusiPeran = new String[0];
        hitungSemua();
    }

    public void hitungSemua() {
        totalPutusan = daftar.size();

        if (totalPutusan == 0) {
            rataRataVonis = 0;
            rataRataDenda = 0;
            jenisNarkotikaTerbanyak = "Tidak ada data";
            distribusiPeran = new String[0];
            return;
        }

        int totalVonis = 0;
        double totalDenda = 0;

        Map<String, Integer> hitungJenis = new HashMap<>();
        Map<String, Integer> hitungPeran = new HashMap<>();

        for (Putusan p : daftar) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            hitungJenis.merge(p.getJenisNarkotika(), 1, Integer::sum);
            hitungPeran.merge(p.getPeranTerdakwa(), 1, Integer::sum);
        }

        rataRataVonis = (double) totalVonis / totalPutusan;
        rataRataDenda = totalDenda / totalPutusan;

        String jenisTerbanyak = "Tidak Diketahui";
        int maxJenis = -1;

        for (Map.Entry<String, Integer> entry : hitungJenis.entrySet()) {
            if (entry.getValue() > maxJenis) {
                maxJenis = entry.getValue();
                jenisTerbanyak = entry.getKey();
            }
        }

        jenisNarkotikaTerbanyak = jenisTerbanyak;

        distribusiPeran = new String[hitungPeran.size()];
        int idx = 0;

        for (Map.Entry<String, Integer> entry : hitungPeran.entrySet()) {
            double persen = (entry.getValue() * 100.0) / totalPutusan;

            distribusiPeran[idx] = String.format(
                    "%s: %d orang (%.1f%%)",
                    entry.getKey(),
                    entry.getValue(),
                    persen
            );

            idx++;
        }
    }

    public void tampilkanLaporan() {
        System.out.println("============ LAPORAN STATISTIK PUTUSAN ============");
        System.out.println("Total Putusan           : " + totalPutusan);
        System.out.printf("Rata-rata Vonis         : %.2f bulan%n", rataRataVonis);
        System.out.printf("Rata-rata Denda         : Rp%.2f%n", rataRataDenda);
        System.out.println("Jenis Narkotika Terbanyak : " + jenisNarkotikaTerbanyak);

        System.out.println("Distribusi Peran Terdakwa:");

        if (distribusiPeran.length == 0) {
            System.out.println("  (Tidak ada data)");
        } else {
            for (String data : distribusiPeran) {
                System.out.println("  - " + data);
            }
        }

        System.out.println("===================================================");
    }

    public int getTotalPutusan() {
        return totalPutusan;
    }

    public double getRataRataVonis() {
        return rataRataVonis;
    }

    public double getRataRataDenda() {
        return rataRataDenda;
    }

    public String getJenisNarkotikaTerbanyak() {
        return jenisNarkotikaTerbanyak;
    }

    public String[] getDistribusiPeran() {
        return distribusiPeran;
    }
}