package praktikum2;

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
                        System.out.print("No Rekening: ");
                        String norek = sc.nextLine();
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("Alamat: ");
                        String alamat = sc.nextLine();
                        System.out.print("Umur: ");
                        int umur = sc.nextInt();
                        System.out.print("Saldo: ");
                        double saldo = sc.nextDouble();
                        Nasabah nb = new Nasabah(norek, nama, alamat, umur, saldo);
                        sc.nextLine();
                        antri.enqueue(nb);
                    }
                    break;
                case 2:
                    DequeueResult dataKeluar = antri.dequeue();
                    if (dataKeluar.success)
                        System.out.println("Data yang dikeluarkan: " + 
                                dataKeluar.value.norek + " " +
                                dataKeluar.value.nama + " " +
                                dataKeluar.value.alamat + " " +
                                dataKeluar.value.umur + " " +
                                dataKeluar.value.saldo);
                    break;
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                case 5:
                    antri.peekRear();
                    break;
            }
        } while (1 <= pilih && pilih <= 5);
    }

    static void menu() {
        System.out.println("========================");
        System.out.println("Masukkan operasi yang diinginkan: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek antrian terdepan");
        System.out.println("4. Cek semua antrian");
        System.out.println("5. Cek antrian terbelakang");
        System.out.println("========================");
    }
}
