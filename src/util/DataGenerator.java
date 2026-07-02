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