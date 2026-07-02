package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private InputHandler() {
    }

    public static int validasiInt(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine();
            try {
                return Integer.parseInt(raw.trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka bulat (integer). Coba lagi.");
            }
        }
    }

    public static int validasiIntMinimal(String prompt, Scanner sc, int minimal) {
        while (true) {
            int nilai = validasiInt(prompt, sc);
            if (nilai < minimal) {
                System.out.println("[ERROR] Nilai harus >= " + minimal + ". Coba lagi.");
                continue;
            }
            return nilai;
        }
    }

    public static double validasiDouble(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine();
            try {
                double nilai = Double.parseDouble(raw.trim());
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka (boleh desimal). Coba lagi.");
            }
        }
    }

    public static double validasiDoubleMinimal(String prompt, Scanner sc, double minimal) {
        while (true) {
            double nilai = validasiDouble(prompt, sc);
            if (nilai < minimal) {
                System.out.println("[ERROR] Nilai harus >= " + minimal + ". Coba lagi.");
                continue;
            }
            return nilai;
        }
    }

    public static String validasiString(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine();
            try {
                if (raw == null || raw.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input tidak boleh kosong.");
                }
                return raw.trim();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage() + " Coba lagi.");
            }
        }
    }

    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine();
            try {
                int pilihan = Integer.parseInt(raw.trim());
                if (pilihan < min || pilihan > max) {
                    throw new InputMismatchException(
                            "Pilihan harus di antara " + min + " - " + max + ".");
                }
                return pilihan;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Masukkan angka pilihan yang valid. Coba lagi.");
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] " + e.getMessage() + " Coba lagi.");
            }
        }
    }
}