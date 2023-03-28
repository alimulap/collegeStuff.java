package TestSearching;

public class Mahasiswa {
    int nim;
    String nama;
    int umur;
    double ipk;

    public Mahasiswa(int ni, String n, int u, double i) {
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }

    public void tampil() {
        System.out.println("Nim = " + nim);
        System.out.println("Nama = " + nama);
        System.out.println("Umur = " + umur);
        System.out.println("Ipk = " + ipk);
    }
}

