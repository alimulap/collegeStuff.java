package Praktikum1;

import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stk = new Stack(5);

        char pilih;
        do {
            System.out.print("Jenis: ");
            String jenis = sc.nextLine();
            System.out.print("Warna: ");
            String warna = sc.nextLine();
            System.out.print("Merk: ");
            String merk = sc.nextLine();
            System.out.print("Ukuran: ");
            String ukuran = sc.nextLine();
            System.out.print("Harga: ");
            double harga = sc.nextDouble();

            Pakaian p = new Pakaian(jenis, warna, merk, ukuran, harga);
            System.out.print("Apakah anda ingin menambahkan data baru ke stack? (y/n)");
            pilih = sc.next().charAt(0);
            sc.nextLine();
            stk.push(p);
        } while (pilih == 'y');

        int menu = -1;
        while (menu == -1) {
            System.out.println("Menu: ");
            System.out.println("1. Push.");
            System.out.println("2. Pop.");
            System.out.println("3. Peek.");
            System.out.println("4. Print.");
            System.out.println("5. Clear.");
            System.out.println("6. Keluar program.");
            System.out.print("Apa yang ingin anda lakukan pada stack pakaian? ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Jenis: ");
                    String jenis = sc.nextLine();
                    System.out.print("Warna: ");
                    String warna = sc.nextLine();
                    System.out.print("Merk: ");
                    String merk = sc.nextLine();
                    System.out.print("Ukuran: ");
                    String ukuran = sc.nextLine();
                    System.out.print("Harga: ");
                    double harga = sc.nextDouble();

                    Pakaian p = new Pakaian(jenis, warna, merk, ukuran, harga);
                    break;
                case 2: stk.pop(); break;
                case 3: stk.peek(); break;
                case 4: stk.print(); break;
                case 5: stk.clear(); break;
            }
            if (menu == 6)
                break;

            menu = -1;
        }
    }
}
