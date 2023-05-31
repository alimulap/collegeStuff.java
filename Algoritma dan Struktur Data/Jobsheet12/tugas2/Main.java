package tugas2;

import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        DaftarFilm df = new DaftarFilm();
        int menuInput = -1;
        while (menuInput != 10) {
            menuInput = menu();
            switch (menuInput) {
                case 1:
                    if (df.add(inputData(), 0)) {
                        System.out.println("------------------------------");
                        System.out.println("Data berhasil ditambahkan");
                        System.out.println("------------------------------");
                    }
                    break;
                case 2:
                    if (df.add(inputData(), df.size() - 1)) {
                        System.out.println("------------------------------");
                        System.out.println("Data berhasil ditambahkan");
                        System.out.println("------------------------------");
                    }
                    break;
                case 3:
                    Film data = inputData();
                    System.out.print("Data Film ini akan masuk di urutan ke-");
                    int idx = sc.nextInt();
                    if(df.add(data, idx)) {
                        System.out.println("------------------------------");
                        System.out.println("Data berhasil ditambahkan");
                        System.out.println("------------------------------");
                    }
                    break;
                case 4:
                    if (!df.remove(0)) {
                        System.out.println("------------------------------");
                        System.out.println("Data berhasil dihapus");
                        System.out.println("------------------------------");
                    }
                    break;
                case 5:
                    if (!df.remove(df.size() - 1)) {
                        System.out.println("------------------------------");
                        System.out.println("Data berhasil dihapus");
                        System.out.println("------------------------------");
                    }
                    break;
                case 6:
                    System.out.print("Hapus data pada index ke-");
                    int index = sc.nextInt();
                    if (!df.remove(index)) {
                        System.out.println("------------------------------");
                        System.out.println("Data berhasil dihapus");
                        System.out.println("------------------------------");
                    }
                    break;
                case 7:
                    df.print();
                    break;
                case 8:
                    System.out.print("Masukkan ID Film yang dicari\n> ");
                    int id = sc.nextInt();
                    df.cariFillm(id);
                    break;
                case 9:
                    df.sortByRating();
                    break;
                case 10:
                    break;
                case -1:
                    System.out.println("Menu tidak tersedia");
                    break;
            }
        }
    }

    static int menu() {
        System.out.println("\n\n");
        System.out.println("==============================");
        System.out.println("DATA FILM LAYAR LEBAR");
        System.out.println("==============================");
        System.out.println(" 1. Tambah Data Awal");
        System.out.println(" 2. Tambah Data Akhir");
        System.out.println(" 3. Tambah Data Index Tertentu");
        System.out.println(" 4. Hapus Data Pertama");
        System.out.println(" 5. Hapus Data Terakhir");
        System.out.println(" 6. Hapus Data Tertentu");
        System.out.println(" 7. Cetak");
        System.out.println(" 8. Cari ID Film");
        System.out.println(" 9. Urut Data Rating Film-DESC");
        System.out.println(" 10. Keluar");
        System.out.print("==============================\n> ");
        int input = sc.nextInt();
        return (input >= 0 && input <= 10) ? input : -1;
    }

    static Film inputData() {
        System.out.println("Masukkan Data Film");
        System.out.print("ID Film:\n> ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Judul Film:\n> ");
        String judul = sc.nextLine();
        System.out.print("Rating Film:\n> ");
        float rating = sc.nextFloat();
        return new Film(id, judul, rating);
    }
}
