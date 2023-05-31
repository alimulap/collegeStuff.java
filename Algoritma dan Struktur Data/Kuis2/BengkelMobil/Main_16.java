package BengkelMobil;

import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AntrianPelanggan antrian = new AntrianPelanggan();
        DaftarLayanan daftarLayanan = new DaftarLayanan();
        System.out.println(
            "=========================================\n" +
            "Selamat datang di pogram Bengkel Mobil\n" +
            "========================================="
        );
        int menu = -1;
        while (menu != 5) {
            menu = menu();
            
            switch (menu) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan nomor hp: ");
                    String noHP = sc.nextLine();
                    Pelanggan baru = new Pelanggan(nama, noHP);
                    antrian.enqueue(baru);
                    break;
                case 2:
                    antrian.print();
                    break;
                case 3:
                    if (antrian.dequeue() == 0) {
                        System.out.print("Masukkan kode layanan: ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Masukkan nama layanan: ");
                        String namaLayanan = sc.nextLine();
                        System.out.print("Masukkan harga layanan: ");
                        int harga = sc.nextInt();
                        sc.nextLine();
                        Layanan layananBaru = new Layanan(kode, namaLayanan, harga);
                        daftarLayanan.add(layananBaru);
                    }
                    break;
                case 4:
                    daftarLayanan.laporan();
                    break;
                case 5:
                    System.out.println("Sampai jumpa.");
                    break;
                case -1:
                    System.out.println("Menu salah");
                    break;
            }
        }
    }

    static int menu() {
        System.out.print(
            "\n" +
            "=========================================\n" +
            "                   MENU\n" +
            "=========================================\n" +
            "1. Tambah antrian.\n" +
            "2. Cetak antrian.\n" +
            "3. Hapus antrian + tambah layanan.\n" +
            "4. Laporan layanan.\n" +
            "5. Keluar.\n" +
            "=========================================\n" +
            "Pilih menu\n" +
            "> "
        );
        int menu = sc.nextInt();
        sc.nextLine();
        return (menu >= 1 || menu <= 5) ? menu : -1;
    }
}
