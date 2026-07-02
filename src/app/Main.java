package app;

import java.util.ArrayList;
import java.util.Scanner;
import controller.KnowledgeController;
import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import util.DataGenerator;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        KnowledgeRepository repository = new KnowledgeRepository();

        ArrayList<Putusan> dataSampel = DataGenerator.generateSampleData();
        for (Putusan p : dataSampel) {
            repository.simpan(p);
        }

        KnowledgeController controller = new KnowledgeController(repository);
        ConsoleView view = new ConsoleView();
        Scanner scanner = view.getScanner();

        view.tampilkanPesan("Selamat datang di KMS Putusan Pengadilan Narkotika.");
        view.tampilkanPesan(dataSampel.size() + " data sampel berhasil dimuat. Total objek Putusan dibuat: "
                + Putusan.getJumlahDibuat());

        boolean berjalan = true;
        while (berjalan) {
            int pilihan = view.tampilkanMenu();