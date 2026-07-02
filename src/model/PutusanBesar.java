package model;

public class PutusanBesar extends Putusan {

    private boolean jaringanInternasional;
    private static final double AMBANG_BARANG_BUKTI_BESAR = 1000.0; // 1 kg

    public PutusanBesar() {
        super();
        this.jaringanInternasional = false;
    }

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