package Tugas;

import java.util.Scanner;

public class Struk {
    int nomerTransaksi, jumlahBarang, totalBayar;
    String tanggalTransaksi;

    Struk(Scanner s) {
        System.out.print("Nomer Transaksi\t\t\t: ");
        this.nomerTransaksi = s.nextInt();
        s.nextLine();
        System.out.print("Tanggal Transaksi\t\t: ");
        this.tanggalTransaksi = s.nextLine();
        System.out.print("Jumlah barang yang dibeli\t: ");
        this.jumlahBarang = s.nextInt();
        System.out.print("Total harga dibayar\t\t: ");
        this.totalBayar = s.nextInt();
    }

    public void print() {
        System.out.println(
            "------------------------------------------\n" + 
            "Nomer transaksi: " + this.nomerTransaksi + "\n" +
            "Tanggal transaksi: " + this.tanggalTransaksi + "\n" +
            "Jumlah barang yang dibeli: " + this.jumlahBarang + "\n" + 
            "Total harga yang dibayar: " + this.totalBayar + "\n\n" );
    }
}
