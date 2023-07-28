package Algoritma;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> data = new ArrayList<>();
    static Scanner w = new Scanner(System.in);
    static Scanner x = new Scanner(System.in);
    static Scanner y = new Scanner(System.in);
    static Scanner z = new Scanner(System.in);
    static String input;
    static int inputan;

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int pilihan;
        System.out.println("\n*========== Pilihan ===========*");
        System.out.println("| 1. Masukkan angka            |");
        System.out.println("| 2. Urutkan data              |");
        System.out.println("| 3. Cari data (Interpolation) |");
        System.out.println("| 4. Cari data (Binary)        |");
        System.out.println("| 5. keluar                    |");
        System.out.println("*==============================*");

        try {
            System.out.print("| Masukkan pilihan : ");
            pilihan = w.nextInt();
            switch (pilihan) {
                case 1:
                    inputanUser();
                case 2:
                    sorting();
                    menu();
                case 3:
                    interpolation();
                    menu();
                case 4:
                    binary();
                    menu();
                case 5:
                    System.out.println("Terima kasih :)");
                    System.exit(0);
                default:
                    System.out.println("Inputan tidak valid !!!");
                    menu();
            }
        } catch (Exception e) {
            System.out.println("Inputan tidak valid !!!");
        }

    }

    static void inputanUser() {
        do {
            try {
                System.out.print("\nMasukkan angka : ");
                inputan = x.nextInt();
                data.add(inputan);
                ulang();
            } catch (Exception e) {
                System.out.println("Inputan tidak valid !!!");
                ulang();
            }
        } while (input.equals("y"));
    }

    static void sorting() {
        int indexMin;

        for (int i = 0; i < data.size(); i++) {
            indexMin = i;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).compareTo(data.get(indexMin)) < 0) {
                    indexMin = j;
                }
            }

            Integer temp = data.get(i);
            data.set(i, data.get(indexMin));
            data.set(indexMin, temp);
        }
        System.out.println("\n" + data + "\n");
    }

    static void interpolation() {
        int indexTerkecil = 0;
        int indexTerbesar = data.size() - 1;
        int indexTengah;
        int key;

        System.out.print("\nMasukkan angka yang ingin dicari : ");
        key = y.nextInt();

        while (indexTerkecil <= indexTerbesar) {
            indexTengah = indexTerkecil + ((key - data.get(indexTerkecil)) * (indexTerbesar - indexTerkecil)
                        / (data.get(indexTerbesar) - data.get(indexTerkecil)));

            if (key == data.get(indexTengah)) {
                System.out.println("\nAngka ditemukan di indeks ke " + indexTengah);
                menu();
            } else if (key < data.get(indexTengah)) {
                indexTerbesar = indexTengah - 1;
            } else if (key > data.get(indexTengah)) {
                indexTerkecil = indexTengah + 1;
            }
        }
        System.out.println("Angka yang dicari tidak ditemukan !!!");
    }

    static void binary() {
        int indexTerkecil = 0;
        int indexTerbesar = data.size() - 1;
        int indexTengah;
        int key;

        System.out.print("\nMasukkan angka yang ingin dicari : ");
        key = z.nextInt();

        while (indexTerkecil <= indexTerbesar) {
            indexTengah = (indexTerkecil + indexTerbesar) / 2;

            if (key == data.get(indexTengah)) {
                System.out.println("\nAngka ditemukan di indeks ke " + indexTengah);
                menu();
            } else if (key < data.get(indexTengah)) {
                indexTerbesar = indexTengah - 1;
            } else if (key > data.get(indexTengah)) {
                indexTerkecil = indexTengah + 1;
            }
        }
        System.out.println("Angka yang dicari tidak ditemukan !!!");
    }

    static void ulang() {
        try {
            System.out.println("\nIngin memasukkan angka lagi ?");
            System.out.print("y/n : ");
            input = x.next();
            if (input.equals("y")) {
                inputanUser();
            } else if (input.equals("n")) {
                menu();
            } else {
                System.out.println("Inputan tidak valid !!!");
                ulang();
            }
        } catch (Exception e) {
            System.out.println("Inputan tidak valid !!!");
            ulang();
        }
    }
}
