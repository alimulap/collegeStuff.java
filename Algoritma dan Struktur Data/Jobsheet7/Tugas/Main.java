package Tugas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.print("Masukkan jumlah struk: ");
        int jumlah = sc.nextInt();
        System.out.println("===========================================");
        Stack stk = new Stack(jumlah);

        for (int i = 0; i < jumlah; ++i)
            stk.push(new Struk(sc));

        int n;
        while (true) {
            System.out.println("\n\n===========================================");
            System.out.print("Masukkan jumlah struk yang ingin dikeluarkan: ");
            n = sc.nextInt();
            if (n <= 0)          { System.out.println("Jumlah tidak boleh 0 atau kurang."); }
            else if (n > jumlah) { System.out.println("Jumlah tidak boleh lebih dari 8."); }
            else                   break;
        }

        System.out.println("===========================================");
        System.out.println("Data struk yang dikeluarkan: ");
        for (int i = 0; i < n; ++i)
            stk.pop().print();

        System.out.println("===========================================");
        System.out.println("Sisa struk yang ada di lemari: ");
        stk.print();
    }
}
