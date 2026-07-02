package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KnowledgeController {

    private final KnowledgeRepository repository;

    public KnowledgeController(KnowledgeRepository repository) {
        this.repository = repository;
    }

    public boolean tambahPutusan(String[] data) {
        if (data == null || data.length < 12) {
            return false;
        }
        try {
            String nomorPerkara = data[0];

            if (repository.cariByNomor(nomorPerkara) != null) {
                throw new IllegalArgumentException(
                        "Nomor perkara '" + nomorPerkara + "' sudah ada di database.");
            }

            String pengadilan = data[1];
            String tanggal = data[2];
            String namaTerdakwa = data[3];
            int umur = Integer.parseInt(data[4]);
            String jenisNarkotika = data[5];
            double berat = Double.parseDouble(data[6]);
            String pasal = data[7];
            String peran = data[8];
            int vonisHukuman = Integer.parseInt(data[9]);
            double vonisDenda = Double.parseDouble(data[10]);
            String hakim = data[11];

            if (berat <= 0) {
                throw new IllegalArgumentException("Berat barang bukti harus lebih dari 0.");
            }
            if (vonisHukuman < 0 || vonisDenda < 0) {
                throw new IllegalArgumentException("Vonis hukuman/denda tidak boleh negatif.");
            }

            Putusan baru = new Putusan(nomorPerkara, pengadilan, tanggal, namaTerdakwa,
                    umur, jenisNarkotika, berat, pasal, peran, vonisHukuman, vonisDenda, hakim);
            repository.simpan(baru);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("[CONTROLLER ERROR] Format angka tidak valid: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("[CONTROLLER ERROR] " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Putusan> cariPutusan(String keyword, String mode) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return hasil;
        }
        if ("nomor".equalsIgnoreCase(mode)) {
            Putusan p = repository.cariByNomor(keyword);
            if (p != null) hasil.add(p);
        } else if ("nama".equalsIgnoreCase(mode)) {
            hasil = repository.cariByNama(keyword);
        }
        return hasil;
    }

    public ArrayList<Putusan> filterPutusan(String kriteria, String nilai) {
        if (kriteria == null) return new ArrayList<>();
        switch (kriteria.toLowerCase()) {
            case "jenis":
                return repository.filterByJenis(nilai);
            case "pengadilan":
                return repository.filterByPengadilan(nilai);
            case "vonis":
                try {
                    String[] parts = nilai.split("-");
                    int min = Integer.parseInt(parts[0].trim());
                    int max = Integer.parseInt(parts[1].trim());
                    return repository.filterByRentangVonis(min, max);
                } catch (Exception e) {
                    System.out.println("[CONTROLLER ERROR] Format rentang vonis tidak valid. Gunakan format: min-max");
                    return new ArrayList<>();
                }
            default:
                return new ArrayList<>();
        }
    }