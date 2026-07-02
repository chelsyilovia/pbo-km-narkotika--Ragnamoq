package util;

import java.util.ArrayList;
import model.Putusan;
import model.PutusanBesar;

public class DataGenerator {

    private static final String[] PENGADILAN = {
            "PN Surabaya", "PN Jakarta Pusat", "PN Jakarta Selatan", "PN Bandung",
            "PN Medan", "PN Semarang", "PN Denpasar", "PN Makassar",
            "PN Yogyakarta", "PN Malang", "PN Palembang", "PN Balikpapan"
    };

    private static final String[] JENIS_NARKOTIKA = {
            "Sabu-sabu", "Ganja", "Ekstasi", "Heroin", "Kokain", "Tembakau Gorila"
    };

    private static final String[] PASAL = {
            "Pasal 114 UU No. 35/2009", "Pasal 112 UU No. 35/2009",
            "Pasal 111 UU No. 35/2009", "Pasal 115 UU No. 35/2009",
            "Pasal 127 UU No. 35/2009"
    };

    private static final String[] PERAN = {
            "Bandar", "Kurir", "Pengguna", "Penyimpan", "Pengedar"
    };

    private static final String[] HAKIM = {
            "Dr. Andi Wijaya, S.H., M.H.", "Siti Rahmawati, S.H.",
            "Bambang Sutrisno, S.H., M.H.", "Maria Christina, S.H.",
            "Hendro Prasetyo, S.H.", "Dewi Lestari, S.H., M.H."
    };

    private static final String[] NAMA_DEPAN = {
            "Ricky", "Budi", "Andi", "Joko", "Slamet", "Dedi", "Agus", "Hendra",
            "Fajar", "Yusuf", "Rudi", "Bayu", "Doni", "Eko", "Fitra", "Gilang",
            "Hadi", "Irwan", "Johan", "Kurniawan", "Lukman", "Made", "Nanda",
            "Oka", "Putra", "Rizky", "Surya", "Taufik", "Umar", "Wawan"
    };

    private static final String[] NAMA_BELAKANG = {
            "Setiawan", "Hariyono", "Pratama", "Saputra", "Wijaya", "Kusuma",
            "Santoso", "Nugroho", "Permana", "Gunawan", "Halim", "Wibowo",
            "Hidayat", "Firmansyah", "Suryadi"
    };

    private DataGenerator() {
    }

    public static ArrayList<Putusan> generateSampleData() {
        ArrayList<Putusan> data = new ArrayList<>();
        int jumlahData = 55;

        for (int i = 1; i <= jumlahData; i++) {
            String nomorPerkara = (1000 + i) + "/Pid.Sus/2024/PN-" + (i % 5 + 1);
            String pengadilan = PENGADILAN[i % PENGADILAN.length];
            String tanggal = String.format("%02d-%02d-2024", (i % 28) + 1, (i % 12) + 1);
            String nama = NAMA_DEPAN[i % NAMA_DEPAN.length] + " "
                    + NAMA_BELAKANG[(i * 3) % NAMA_BELAKANG.length];
            int umur = 19 + (i % 40); // 19 - 58 tahun
            String jenis = JENIS_NARKOTIKA[i % JENIS_NARKOTIKA.length];
            double berat = 0.5 + (i * 13.7 % 1200);
            String pasal = PASAL[i % PASAL.length];
            String peran = PERAN[i % PERAN.length];
            int vonisBulan = 3 + (i * 5 % 90);
            double denda = 1_000_000.0 + (i * 1_500_000.0 % 800_000_000.0);
            String hakim = HAKIM[i % HAKIM.length];

            Putusan p;
            if (berat >= 1000.0 || i % 11 == 0) {
                boolean jaringanInternasional = (i % 13 == 0);
                p = new PutusanBesar(nomorPerkara, pengadilan, tanggal, nama, umur,
                        jenis, berat, pasal, peran, vonisBulan, denda, hakim,
                        jaringanInternasional);
            } else {
                p = new Putusan(nomorPerkara, pengadilan, tanggal, nama, umur,
                        jenis, berat, pasal, peran, vonisBulan, denda, hakim);
            }
            data.add(p);
        }
        return data;
    }
}