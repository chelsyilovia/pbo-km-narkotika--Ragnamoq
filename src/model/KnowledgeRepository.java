package model;

import java.util.ArrayList;
import java.util.Comparator;

public class KnowledgeRepository {

    private ArrayList<Putusan> daftarPutusan;

    public KnowledgeRepository() {
        this.daftarPutusan = new ArrayList<>();
    }

    public void simpan(Putusan p) {
        if (p == null) {
            throw new IllegalArgumentException("Objek Putusan tidak boleh null.");
        }
        daftarPutusan.add(p);
    }

    public Putusan cariByNomor(String nomor) {
        if (nomor == null) return null;
        for (Putusan p : daftarPutusan) {
            if (p.getNomorPerkara().equalsIgnoreCase(nomor.trim())) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Putusan> cariByNama(String nama) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (nama == null || nama.trim().isEmpty()) return hasil;
        String keyword = nama.trim().toLowerCase();
        for (Putusan p : daftarPutusan) {
            if (p.getNamaTerdakwa().toLowerCase().contains(keyword)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public ArrayList<Putusan> filterByJenis(String jenis) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (jenis == null || jenis.trim().isEmpty()) return hasil;
        String keyword = jenis.trim().toLowerCase();
        for (Putusan p : daftarPutusan) {
            if (p.getJenisNarkotika().toLowerCase().contains(keyword)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public ArrayList<Putusan> filterByPengadilan(String pengadilan) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (pengadilan == null || pengadilan.trim().isEmpty()) return hasil;
        String keyword = pengadilan.trim().toLowerCase();
        for (Putusan p : daftarPutusan) {
            if (p.getPengadilan().toLowerCase().contains(keyword)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public ArrayList<Putusan> filterByRentangVonis(int min, int max) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getVonisHukuman() >= min && p.getVonisHukuman() <= max) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public boolean hapus(String nomor) {
        Putusan target = cariByNomor(nomor);
        if (target == null) {
            return false;
        }
        return daftarPutusan.remove(target);
    }

    public boolean update(String nomor, Putusan dataBaru) {
        Putusan target = cariByNomor(nomor);
        if (target == null) {
            return false;
        }
        int index = daftarPutusan.indexOf(target);
        daftarPutusan.set(index, dataBaru);
        return true;
    }

    public void sortByVonis() {
        java.util.Collections.sort(daftarPutusan);
    }

    public void sortByDendaDescending() {
        daftarPutusan.sort(Comparator.comparingDouble(Putusan::getVonisDenda).reversed());
    }

    public ArrayList<Putusan> getDaftarSemua() {
        return daftarPutusan;
    }

    public int getTotalData() {
        return daftarPutusan.size();
    }
}