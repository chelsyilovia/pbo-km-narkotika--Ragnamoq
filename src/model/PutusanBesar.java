package model;

/**
 * Merepresentasikan putusan narkotika dengan kategori kasus besar.
 * Kasus besar ditentukan berdasarkan berat barang bukti atau
 * keterlibatan jaringan internasional.
 */
public class PutusanBesar extends Putusan {

    /**
     * Menunjukkan apakah kasus melibatkan jaringan internasional.
     */
    private boolean jaringanInternasional;

    /**
     * Ambang batas berat barang bukti (gram)
     * agar dikategorikan sebagai kasus besar.
     */
    private static final double AMBANG_BARANG_BUKTI_BESAR = 1000.0; // 1 kg

    /**
     * Constructor default.
     */
    public PutusanBesar() {
        super();
        this.jaringanInternasional = false;
    }

    /**
     * Constructor lengkap untuk putusan kasus besar.
     */
    public PutusanBesar(String nomorPerkara, String pengadilan, String tanggalPutusan,
                        String namaTerdakwa, int umurTerdakwa, String jenisNarkotika,
                        double beratBarangBukti, String pasalDilanggar, String peranTerdakwa,
                        int vonisHukuman, double vonisDenda, String namaHakim,
                        boolean jaringanInternasional) {

        super(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa,
                umurTerdakwa, jenisNarkotika, beratBarangBukti,
                pasalDilanggar, peranTerdakwa,
                vonisHukuman, vonisDenda, namaHakim);

        this.jaringanInternasional = jaringanInternasional;
    }

    public boolean isJaringanInternasional() {
        return jaringanInternasional;
    }

    public void setJaringanInternasional(boolean jaringanInternasional) {
        this.jaringanInternasional = jaringanInternasional;
    }

    /**
     * Mengembalikan kategori hukuman dengan mempertimbangkan
     * berat barang bukti dan jaringan internasional.
     */
    @Override
    public String getKategoriHukuman() {
        String kategoriDasar = super.getKategoriHukuman();

        if (getBeratBarangBukti() >= AMBANG_BARANG_BUKTI_BESAR || jaringanInternasional) {
            return kategoriDasar + " (Kasus Besar)";
        }

        return kategoriDasar;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", jaringanInternasional=" + jaringanInternasional;
    }
}