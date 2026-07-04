# pbo-km-narkotika--Ragnamoq
# KMS Putusan Pengadilan Narkotika
**Knowledge Management System**  untuk Putusan Pengadilan Narkotika berbasis Java
# Tugas Besar Pemrograman Berorientasi Object (PBO) — Semester Genap 2025/2026
# Deskripsi Proyek
Aplikasi ini adalah sistem manajemen pengetahuan (**KMS**) yang mengelola data putusan pengadilan pidana narkotika menggunakan bahasa pemrograman **Java JDK 11** dengan pola arsitektur **MVC (Model–View–Controller)**.
Aplikasi berjalan dalam mode **konsol interaktif berbasis teks**.
# Anggota Kelompok
| No |    Nama Lengkap    |       NIM       | Kelas |                Peran                   |       Branch       |
|----|--------------------|-----------------|-------|----------------------------------------|--------------------|
| 1  | Chelsy Ilovia R.P  | 202510370110052 |   B   |     GUI Designer / View Developer      |    feature/view    |
| 2  | Ghazi Alghifari A. | 202510370110053 |   B   | Backend Developer / Controller Engineer| feature/controller |
| 3  | Rizal Yoga Bachtiar| 202010370311469 |   B   |      Knowledge / Database Engineer     |    feature/model   |


# Video Demo
**(https://youtu.be/sSnBz4Dyckg?si=Sx_rjsUZk_jya-Hb)**
Durasi ±5 menit — mencakup demo fitur CRUD, pencarian, filter, statistik, validasi input, dan penjelasan kode OOP

# Struktur Proyek
kms_java/
├── src/
│   ├── model/
│   │   ├── Putusan.java              ← Entity utama (enkapsulasi, overloading, static, Comparable)
│   │   ├── PutusanBesar.java         ← Subclass Putusan (inheritance + method overriding)
│   │   ├── KnowledgeRepository.java  ← ArrayList CRUD, pencarian, filter, sorting
│   │   └── StatistikPutusan.java     ← Kalkulasi statistik (rata-rata vonis, denda, distribusi)
│   ├── view/
│   │   └── ConsoleView.java          ← Tampilan menu & tabel konsol (tanpa logika bisnis)
│   ├── controller/
│   │   └── KnowledgeController.java  ← Jembatan Model ↔ View, validasi, ekspor
│   ├── util/
│   │   ├── InputHandler.java         ← Validasi input + exception handling
│   │   └── DataGenerator.java        ← Generator 55 data sampel putusan
│   └── app/
│       └── Main.java                 ← Entry point aplikasi
├── data/
│   └── sample_putusan.csv            ← Contoh dataset format CSV
├── .gitignore
└── README.md

# Cara Kompilasi
Pastikan **Java JDK 11 atau lebih baru** sudah terinstal.
Cek versi Java:
bash
java -version

**Linux / Mac:**
bash
# Masuk ke folder project
cd kms_java
# Buat folder output
mkdir out
# Kompilasi semua file Java
javac -d out $(find src -name "*.java")
**Windows PowerShell:**
powershell
mkdir out
javac -d out (Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName })

**IntelliJ IDEA:**
- Klik kanan folder src → **Mark Directory as** → **Sources Root**
- Klik **Build** → **Build Project**

# Cara Menjalankan
bash
java -cp out app.Main
Setelah berjalan, pilih menu 0–11:

==================================================
   KNOWLEDGE MANAGEMENT SYSTEM - PUTUSAN NARKOTIKA
==================================================
 1.  Tambah Putusan Baru
 2.  Tampilkan Semua Putusan
 3.  Cari Putusan (Nomor Perkara)
 4.  Cari Putusan (Nama Terdakwa)
 5.  Filter berdasarkan Jenis Narkotika
 6.  Filter berdasarkan Pengadilan
 7.  Filter berdasarkan Rentang Vonis (bulan)
 8.  Hapus Putusan
 9.  Tampilkan Statistik
 10. Urutkan Data (Sort by Vonis / Denda)
 11. Ekspor Statistik ke File (.txt)
 0.  Keluar
==================================================

# Fitur Aplikasi
# Fitur Wajib
| No |                              Fitur                          |Status|
|----|-------------------------------------------------------------|------|
|  1 |                  Tambah putusan baru (Create)               |  ✅ |
|  2 |                Tampilkan semua putusan (Read)               |  ✅ |
|  3 |        Cari putusan by nomor perkara / nama terdakwa        |  ✅ |
|  4 |    Filter by jenis narkotika / pengadilan / rentang vonis   |  ✅ |
|  5 |                    Hapus putusan (Delete)                   |  ✅ |
|  6 |     Statistik (rata-rata vonis, denda, distribusi peran)    |  ✅ |
|  7 |      Validasi input & exception handling (tidak crash)      |  ✅ |
|  8 |       ArrayList sebagai koleksi utama (min. 55 data)        |  ✅ |
|  9 |       Arsitektur MVC (View tidak akses Model langsung)      |  ✅ |
| 10 |         Repository Git aktif dengan branch per peran        |  ✅ |

# Fitur Bonus
|                        Fitur                       |        Poin        | Status |
|----------------------------------------------------|--------------------|--------|
| Sorting by vonis (Comparable) & denda (Comparator) |         +3         |    ✅  |
|           Ekspor statistik ke file .txt            |         +2         |    ✅  |

# Implementasi Konsep OOP

|          Konsep OOP         |                              Lokasi di Kode                              |
|-----------------------------|--------------------------------------------------------------------------|
|       **Enkapsulasi**       |   Semua field Putusan.java bersifat private, diakses via getter/setter   |
| **Constructor Overloading** |          Putusan() no-arg, Putusan(12 param), Putusan(5 param)           |
|   **Method Overloading**    |         tampilkan() dan tampilkan(boolean detail) di Putusan.java        |
|  **Inheritance (extends)**  |                       PutusanBesar extends Putusan                       |
|  **Interface (implements)** |                  Putusan implements Comparable<Putusan>                  |
|    **Method Overriding**    |            getKategoriHukuman(), toString() di PutusanBesar.java         |
|  **Static Field & Method**  |    jumlahDibuat (field) & getJumlahDibuat() (method) di Putusan.java     |
|       **ArrayList**         |           KnowledgeRepository.daftarPutusan sebagai koleksi utama        |
|      **Array Statis**       |              StatistikPutusan.distribusiPeran bertipe String[]           |
|    **Exception Handling**   |        try-catch di InputHandler.java dan KnowledgeController.java       |
|       **Comparable**        |           compareTo() di Putusan.java untuk sort by vonis                |
|       **Comparator**        |           Lambda di KnowledgeRepository.sortByDendaDescending()          |


# Arsitektur MVC

[VIEW]                 [CONTROLLER]                [MODEL]
ConsoleView   ──►   KnowledgeController   ──►   KnowledgeRepository
                           │               ──►   Putusan
                           │               ──►   PutusanBesar
                           ▼               ──►   StatistikPutusan
                      InputHandler
                     (validasi input)

**Aturan MVC yang diterapkan:**
- View **tidak pernah** mengakses Model secara langsung
- Semua logika bisnis ada di Controller dan Model, **bukan** di View atau Main
- Main.java hanya bertugas sebagai entry point - inisialisasi komponen MVC dan loop menu

# Strategi Git Branching
main
 └── develop
      ├── feature/model       ← Anggota 1 (Putusan, Repository, Statistik)
      ├── feature/view        ← Anggota 2 (ConsoleView)
      └── feature/controller  ← Anggota 3 (Controller, InputHandler, Main)

- Setiap fitur dikerjakan di branch masing-masing
- Penggabungan ke develop melalui **Pull Request** yang di-review anggota lain
- main hanya menerima merge dari develop setelah semua fitur siap

# Dataset
- **Jumlah data sampel:** 55 putusan (hard-coded di DataGenerator.java)
- **Format alternatif:** data/sample_putusan.csv
- **Sumber referensi:** Direktori Putusan Mahkamah Agung RI (putusan.mahkamahagung.go.id)
- **Jenis kasus:** Pidana Khusus Narkotika (Pid.Sus) dari berbagai Pengadilan Negeri di Indonesia

# Atribut Data Putusan
|       Field      |  Tipe  |                  Keterangan                  |
|------------------|--------|----------------------------------------------|
|   nomorPerkara   | String | Nomor perkara, mis. 1001/Pid.Sus/2024/PN Sby |
|     pengadilan   | String |            Nama Pengadilan Negeri            |
|  tanggalPutusan  | String |          Tanggal putusan dijatuhkan          |
|   namaTerdakwa   | String |             Nama lengkap terdakwa            |
|   umurTerdakwa   |  int   |             Usia terdakwa (tahun)            |
|  jenisNarkotika  | String |   Sabu-sabu, ganja, ekstasi, heroin, dll     |
| beratBarangBukti | double |          Berat barang bukti (gram)           |
|  pasalDilanggar  | String |             Pasal UU No. 35/2009             |
|   peranTerdakwa  | String | Bandar, kurir, pengguna, penyimpan, pengedar |
|   vonisHukuman   |  int   |         Lama hukuman penjara (bulan)         |
|    vonisDenda    | double |            Besaran denda (rupiah)            |
|     namaHakim    | String |                Nama hakim ketua              |

EOF
echo "Done"
