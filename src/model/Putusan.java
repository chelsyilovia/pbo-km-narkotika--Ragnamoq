package model;

public class Putusan implements Comparable<Putusan> {

    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;
    private double vonisDenda;
    private String namaHakim;

    private static int jumlahDibuat = 0;

    public Putusan() {
        this.nomorPerkara = "BELUM DIISI";
        this.pengadilan = "BELUM DIISI";
        this.tanggalPutusan = "BELUM DIISI";
        this.namaTerdakwa = "BELUM DIISI";
        this.umurTerdakwa = 0;
        this.jenisNarkotika = "BELUM DIISI";
        this.beratBarangBukti = 0.0;
        this.pasalDilanggar = "BELUM DIISI";
        this.peranTerdakwa = "BELUM DIISI";
        this.vonisHukuman = 0;
        this.vonisDenda = 0.0;
        this.namaHakim = "BELUM DIISI";
        jumlahDibuat++;
    }

    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan,
                   String namaTerdakwa, int umurTerdakwa, String jenisNarkotika,
                   double beratBarangBukti, String pasalDilanggar, String peranTerdakwa,
                   int vonisHukuman, double vonisDenda, String namaHakim) {
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;
        jumlahDibuat++;
    }

    public Putusan(String nomorPerkara, String namaTerdakwa, String jenisNarkotika,
                   double beratBarangBukti, int vonisHukuman) {
        this(nomorPerkara, "BELUM DIISI", "BELUM DIISI", namaTerdakwa, 0,
                jenisNarkotika, beratBarangBukti, "BELUM DIISI", "BELUM DIISI",
                vonisHukuman, 0.0, "BELUM DIISI");
        jumlahDibuat--;
        jumlahDibuat++;
    }

    public String getNomorPerkara() {
        return nomorPerkara;
    }

    public void setNomorPerkara(String nomorPerkara) {
        if (nomorPerkara == null || nomorPerkara.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor perkara tidak boleh kosong.");
        }
        this.nomorPerkara = nomorPerkara;
    }

    public String getPengadilan() {
        return pengadilan;
    }

    public void setPengadilan(String pengadilan) {
        this.pengadilan = (pengadilan == null || pengadilan.trim().isEmpty())
                ? "Tidak Diketahui" : pengadilan;
    }

    public String getTanggalPutusan() {
        return tanggalPutusan;
    }

    public void setTanggalPutusan(String tanggalPutusan) {
        this.tanggalPutusan = (tanggalPutusan == null) ? "Tidak Diketahui" : tanggalPutusan;
    }

    public String getNamaTerdakwa() {
        return namaTerdakwa;
    }

    public void setNamaTerdakwa(String namaTerdakwa) {
        if (namaTerdakwa == null || namaTerdakwa.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama terdakwa tidak boleh kosong.");
        }
        this.namaTerdakwa = namaTerdakwa;
    }

    public int getUmurTerdakwa() {
        return umurTerdakwa;
    }

    public void setUmurTerdakwa(int umurTerdakwa) {
        if (umurTerdakwa < 0 || umurTerdakwa > 120) {
            throw new IllegalArgumentException("Umur terdakwa tidak valid: " + umurTerdakwa);
        }
        this.umurTerdakwa = umurTerdakwa;
    }

    public String getJenisNarkotika() {
        return jenisNarkotika;
    }

    public void setJenisNarkotika(String jenisNarkotika) {
        if (jenisNarkotika == null || jenisNarkotika.trim().isEmpty()) {
            throw new IllegalArgumentException("Jenis narkotika tidak boleh kosong.");
        }
        this.jenisNarkotika = jenisNarkotika;
    }

    public double getBeratBarangBukti() {
        return beratBarangBukti;
    }

    public void setBeratBarangBukti(double beratBarangBukti) {
        if (beratBarangBukti < 0) {
            throw new IllegalArgumentException("Berat barang bukti tidak boleh negatif.");
        }
        this.beratBarangBukti = beratBarangBukti;
    }

    public String getPasalDilanggar() {
        return pasalDilanggar;
    }

    public void setPasalDilanggar(String pasalDilanggar) {
        this.pasalDilanggar = (pasalDilanggar == null || pasalDilanggar.trim().isEmpty())
                ? "Tidak Diketahui" : pasalDilanggar;
    }

    public String getPeranTerdakwa() {
        return peranTerdakwa;
    }

    public void setPeranTerdakwa(String peranTerdakwa) {
        this.peranTerdakwa = (peranTerdakwa == null || peranTerdakwa.trim().isEmpty())
                ? "Tidak Diketahui" : peranTerdakwa;
    }

    public int getVonisHukuman() {
        return vonisHukuman;
    }

    public void setVonisHukuman(int vonisHukuman) {
        if (vonisHukuman < 0) {
            throw new IllegalArgumentException("Vonis hukuman tidak boleh negatif.");
        }
        this.vonisHukuman = vonisHukuman;
    }

    public double getVonisDenda() {
        return vonisDenda;
    }

    public void setVonisDenda(double vonisDenda) {
        if (vonisDenda < 0) {
            throw new IllegalArgumentException("Vonis denda tidak boleh negatif.");
        }
        this.vonisDenda = vonisDenda;
    }

    public String getNamaHakim() {
        return namaHakim;
    }

    public void setNamaHakim(String namaHakim) {
        this.namaHakim = (namaHakim == null || namaHakim.trim().isEmpty())
                ? "Tidak Diketahui" : namaHakim;
    }

    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    public void tampilkan() {
        System.out.printf("%-22s | %-20s | %-12s | %3d bln%n",
                nomorPerkara, namaTerdakwa, jenisNarkotika, vonisHukuman);
    }

    public void tampilkan(boolean detail) {
        if (!detail) {
            tampilkan();
            return;
        }
        System.out.println("=========================================");
        System.out.println("Nomor Perkara     : " + nomorPerkara);
        System.out.println("Pengadilan        : " + pengadilan);
        System.out.println("Tanggal Putusan   : " + tanggalPutusan);
        System.out.println("Nama Terdakwa     : " + namaTerdakwa);
        System.out.println("Umur Terdakwa     : " + umurTerdakwa + " tahun");
        System.out.println("Jenis Narkotika   : " + jenisNarkotika);
        System.out.println("Berat Barang Bukti: " + beratBarangBukti + " gram");
        System.out.println("Pasal Dilanggar   : " + pasalDilanggar);
        System.out.println("Peran Terdakwa    : " + peranTerdakwa);
        System.out.println("Vonis Hukuman     : " + vonisHukuman + " bulan");
        System.out.println("Vonis Denda       : Rp" + vonisDenda);
        System.out.println("Nama Hakim        : " + namaHakim);
        System.out.println("Kategori Hukuman  : " + getKategoriHukuman());
        System.out.println("=========================================");
    }

    public String getKategoriHukuman() {
        if (vonisHukuman < 12) {
            return "Ringan";
        } else if (vonisHukuman <= 48) {
            return "Sedang";
        } else {
            return "Berat";
        }
    }

    @Override
    public int compareTo(Putusan other) {
        return Integer.compare(this.vonisHukuman, other.vonisHukuman);
    }

    @Override
    public String toString() {
        return "Putusan{" +
                "nomorPerkara='" + nomorPerkara + '\'' +
                ", namaTerdakwa='" + namaTerdakwa + '\'' +
                ", jenisNarkotika='" + jenisNarkotika + '\'' +
                ", vonisHukuman=" + vonisHukuman + " bulan" +
                ", kategori=" + getKategoriHukuman() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Putusan)) return false;
        Putusan other = (Putusan) obj;
        return this.nomorPerkara != null && this.nomorPerkara.equalsIgnoreCase(other.nomorPerkara);
    }

    @Override
    public int hashCode() {
        return nomorPerkara == null ? 0 : nomorPerkara.toLowerCase().hashCode();
    }
}