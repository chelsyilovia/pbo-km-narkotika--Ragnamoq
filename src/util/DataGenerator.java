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