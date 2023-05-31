package tugas;

import java.util.Scanner;

class QueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int n = sc.nextInt();

        Queue antri = new Queue(n);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            System.out.println("========================");
            switch (pilih) {
                case 1:
                    if (antri.isFull())
                        System.out.println("Queue penuh");
                    else {
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("No HP: ");
                        int noHP = sc.nextInt();
                        Pembeli pb = new Pembeli(nama, noHP);
                        sc.nextLine();
                        antri.enqueue(pb);
                    }
                    break;
                case 2:
                    DequeueResult dataKeluar = antri.dequeue();
                    if (dataKeluar.success)
                        System.out.println("Data yang dikeluarkan: " + 
                                dataKeluar.value.nama + " " +
                                dataKeluar.value.noHP);
                    break;
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.peekRear();
                    break;
                case 5:
                    antri.daftarPembeli();
                    break;
                case 6:
                    System.out.print("Masukkan nama pembeli: ");
                    String nama = sc.nextLine();
                    antri.peekPosition(nama);
                    break;
            }
        } while (1 <= pilih && pilih <= 6);
    }

    static void menu() {
        System.out.println("========================");
        System.out.println("Masukkan operasi yang diinginkan: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek antrian terdepan");
        System.out.println("4. Cek antrian terbelakang");
        System.out.println("5. Cek semua pembeli");
        System.out.println("6. Cek posisi pembeli");
        System.out.println("========================");
    }
}
