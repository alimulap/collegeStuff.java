package TestSearching;

import java.util.Scanner;
import MergeSortTest.MergeSorting;

public class MahasiswaMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianMhs data = new PencarianMhs();
        int jumMhs = 5;

        System.out.println("---------------------------------------");
        System.out.println("Masukkan data mahasiswa secara urut dari Nim terkecil");
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("---------------------------------------");
            System.out.print("Nim\t : ");
            int nim = s.nextInt();
            System.out.print("Nama\t : ");
            String nama = s1.nextLine();
            System.out.print("Umur\t : ");
            int umur = s.nextInt();
            System.out.print("IPK\t : ");
            double ipk = s.nextDouble();

            Mahasiswa m = new Mahasiswa(nim, nama, umur, ipk);
            data.tambah(m);
        }

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Data keseluruhan mahasiswa: ");
        data.tampil();

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("Pencarian data: ");
        System.out.println("Masukkan nim mahasiswa yang dicari: ");
        System.out.print("NIM: ");
        int cari = s.nextInt();

        System.out.println("---------------------------------------");
        System.out.println("Menggunakan sequential search");
        int posisi = data.FindSeqSearch(cari);
        data.Tampilposisi(cari, posisi);
        data.TampilData(cari, posisi);

        int[] nimMhs = new int[jumMhs];
        for (int i = 0; i < jumMhs; i++) {
            nimMhs[i] = data.listMhs[i].nim;
        }

        MergeSorting mSort = new MergeSorting();
        mSort.mergeSort(nimMhs);

        data.sortByNim(nimMhs);

        System.out.println("---------------------------------------");
        System.out.println("Menggunakan binary search");
        posisi = data.FindBinarySearch(cari, 0, jumMhs - 1);
        data.Tampilposisi(cari, posisi);
        data.TampilData(cari, posisi);

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("Pencarian data: ");
        System.out.println("Masukkan nama mahasiswa yang dicari: ");
        System.out.print("Nama: ");
        s.nextLine();
        String cari2 = s1.nextLine();

        data.FindSeqSearchNama(cari2);
    }
}
