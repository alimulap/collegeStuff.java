package tugas;

import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Queue antrian = new Queue();
        antrian.enqueue(new PenerimaVaksin(123, "Joko"));
        antrian.enqueue(new PenerimaVaksin(124, "Mely"));
        antrian.enqueue(new PenerimaVaksin(135, "Johan"));
        antrian.enqueue(new PenerimaVaksin(146, "Rosi"));
        int input = -1;
        while (input != 4) {
            input = menu();

            switch (input) {
                case 1: antrian.enqueue(tambahData()); break;
                case 2: antrian.dequeue(); break;
                case 3: antrian.print(); break;
                case 4: break;
                case -1: System.out.println("Input salah"); break;
            }
        }

    }

    static int menu() {
        System.out.println();
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("PENGANTRI VAKSINE EXTRAVAGANZA");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("1. Tambah Data Penerima Vaksin");
        System.out.println("2. Hapus Data Pengantri Vaksin");
        System.out.println("3. Daftar Penerima Vaksin");
        System.out.println("4. Keluar");
        System.out.println("++++++++++++++++++++++++++++++");
        int input = sc.nextInt();
        return (input <= 4 || input >= 1) ? input : -1;
    }

    static PenerimaVaksin tambahData() {
        System.out.println("=============================");
        System.out.println("Masukkan Data Penerima Vaksin");
        System.out.println("=============================");
        System.out.print("Nomer Antrian:\n> ");
        int nomor = sc.nextInt();
        sc.nextLine();
        System.out.print("Nama Antrian:\n> ");
        String nama = sc.nextLine();
        return new PenerimaVaksin(nomor, nama);
    }
}
