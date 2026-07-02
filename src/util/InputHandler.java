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