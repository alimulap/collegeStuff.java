package src;

import java.util.Scanner;

public class Application {
    int maxData = 100;
    Rekening[] dataRekening;
    Transaksi[] dataTransaksi;
    int idxRekening = 0;
    int idxTransaksi = 0;

    public Application() {
        this.dataRekening = new Rekening[maxData];
        this.dataTransaksi = new Transaksi[maxData];
    }

    public void run(Scanner sc) {
        this.menu(sc);
    }

    public void initData() {
        this.inputDataRekening("16030927 3084", "Wallace", "Chase Castro", "1-458-264-3263", "ligula.Nullam@tacitisociosqu.edu");
        this.inputDataRekening("16100617 0573", "Darius", "Julian Daniel", "1-357-843-0547", "nec@lectusjusto.org");
        this.inputDataRekening("16240401 2243", "Fuller", "Finn Dunlap", "571-7062", "convallis@Vestibulumanteipsum.org");
        this.inputDataTransaksi(898214, 494048, 3587, "2021-03-09 07:54:42", "Setor");
        this.inputDataTransaksi(205420, 200162, 775880, "2021-06-25 10:23:00", "Tarik");
        this.inputDataTransaksi(838632, 350929, 328316, "2021-09-18 23:00:04", "Tarik");
    }

    void menu(Scanner sc) {
        while (true) {
            int pilihan = -1;
            while (pilihan == -1) {
                System.out.print(
                        "Menu:\n" +
                        "1. Tampil data\n" +
                        "2. Input data\n" +
                        "3. Keluar\n" +
                        "Pilih: "
                        );
                pilihan = sc.nextInt();
                System.out.println();

                if (pilihan > 4 || pilihan < 1) {
                    System.out.println("Menu tidak tersedia.");
                    pilihan = -1;
                }
            }

            System.out.println("\n\n");

            switch (pilihan) {
                case 1:
                    this.tampilData(sc);
                    break;
                case 2:
                    this.inputData(sc);
                    break;
                case 3:
                    return;
            }
        }
    }

    void tampilData(Scanner sc) {
        while (true) {
            int pilihan = -1;
            while (pilihan == -1) {
                System.out.print(
                        "Menu:\n" +
                        "1. Data Rekening\n" +
                        "2. Data Rekening urut nama\n" +
                        "3. Data Transaksi\n" +
                        "4. Keluar\n" + 
                        "Pilih: "
                        );
                pilihan = sc.nextInt();
                System.out.println();

                if (pilihan > 4 || pilihan < 1) {
                    System.out.println("Menu tidak tersedia.");
                    pilihan = -1;
                }
            }

            System.out.println("\n\n");

            switch (pilihan) {
                case 1:
                    for (int i = 0; i < idxRekening; ++i)
                        this.dataRekening[i].tampil();
                    break;
                case 2:
                    this.urutkanRekeningByNama();
                    for (int i = 0; i < idxRekening; ++i)
                        this.dataRekening[i].tampil();
                    break;
                case 3:
                    for (int i = 0; i < idxTransaksi; ++i)
                        this.dataTransaksi[i].tampil();
                    break;
                case 4:
                    return;
            }
        }
    }

    void inputData(Scanner sc) {
        while (true) {
            int pilihan = -1;
            while (pilihan == -1) {
                System.out.print(
                        "Menu:\n" +
                        "1. Data Rekening\n" +
                        "2. Data Transaksi\n" +
                        "3. Keluar\n" + 
                        "Pilih: "
                        );
                pilihan = sc.nextInt();
                System.out.println();

                if (pilihan > 3 || pilihan < 1) {
                    System.out.println("Menu tidak tersedia.");
                    pilihan = -1;
                }
            }

            System.out.println("\n\n");

            switch (pilihan) {
                case 1:
                    sc.nextLine();
                    System.out.print("Masukkan nomer rekening: ");
                    String nrek = sc.nextLine();
                    System.out.print("Masukkan nama: ");
                    String nm = sc.nextLine();
                    System.out.print("Masukkan nama ibu: ");
                    String nmI = sc.nextLine();
                    System.out.print("Masukkan phone number: ");
                    String ph = sc.nextLine();
                    System.out.print("Masukkan email address: ");
                    String em = sc.nextLine();
                    this.inputDataRekening(nrek, nm, nmI, ph, em);
                    break;
                case 2:
                    System.out.print("Masukkan saldo: ");
                    double sld = sc.nextDouble();
                    System.out.print("Masukkan saldo awal: ");
                    double sldaw = sc.nextDouble();
                    System.out.print("Masukkan saldo akhir: ");
                    double sldak = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Masukkan tanggal transaksi: ");
                    String tglTr = sc.nextLine();
                    System.out.print("Masukkan tipe transaksi: ");
                    String tp = sc.nextLine();
                    this.inputDataTransaksi(sld, sldaw, sldak, tglTr, tp);
                    break;
                case 3:
                    return;
            }
        }
    }

    void inputDataRekening(String nrek, String nm, String nmI, String ph, String em) {
        Rekening rekening = new Rekening(nrek, nm, nmI, ph, em);
        this.dataRekening[idxRekening++] = rekening;
    }

    void inputDataTransaksi(double sld, double sldaw, double sldak, String tglTr, String tp) {
        Transaksi transaksi = new Transaksi(sld, sldaw, sldak, tglTr, tp);
        this.dataTransaksi[idxTransaksi++] = transaksi;
    }

    void urutkanRekeningByNama() {
        Rekening temp;
        for (int i = 0; i < this.idxRekening-1; ++i) {
            for (int j = 1; j < this.idxRekening-i; ++j) {
                if (this.dataRekening[j].nama.charAt(0) < this.dataRekening[j].nama.charAt(0)) {
                    temp = this.dataRekening[j];
                    this.dataRekening[j] = this.dataRekening[j-1];
                    this.dataRekening[j-1] = temp;
                }
            }
        }
    }
}
