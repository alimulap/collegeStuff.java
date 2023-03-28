package TestSearching;

import java.util.Arrays;

public class PencarianMhs {
    Mahasiswa listMhs[] = new Mahasiswa[5];
    int idx;

    //public PencarianMhs(int jumlah) {
    //    listMhs = new Mahasiswa[jumlah[;
    //    idx = 0;
    //}

    public void tambah(Mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    public void tampil() {
        for (Mahasiswa m : listMhs) {
            m.tampil();
            System.out.println("---------------------------");
        }
    }

    public int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].nim == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    public int FindBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].nim) {
                return mid;
            } else if (listMhs[mid].nim > cari) {
                return FindBinarySearch(cari, left, mid - 1);
            } else {
                return FindBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }

    public void FindSeqSearchNama(String nama) {
        int[] ditemukan = new int[0];
        for (int i = 0; i < listMhs.length; i++) {
            if (listMhs[i].nama.equalsIgnoreCase(nama)) {
                int[] temp = new int[ditemukan.length+1];
                for (int j = 0; j < ditemukan.length; j++) {
                    temp[j] = ditemukan[j];
                }
                temp[ditemukan.length] = i;
                ditemukan = temp;
            }
        }
        if (ditemukan.length > 0) {
            System.out.println("Data ditemukan.");
            for (int i : ditemukan) {
                System.out.println("---------------------------");
                listMhs[i].tampil();
            }
            System.out.println("---------------------------");
        } else {
            System.out.println("Data " + nama + " tidak ditemukan");
        }
    }
    

    public void Tampilposisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("data : " + x + " ditemukan pada index " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public void TampilData(int x, int pos) {
        if (pos != -1) {
            System.out.println("Nim\t : " + x);
            System.out.println("Nama\t : " + listMhs[pos].nama);
            System.out.println("Umur\t : " + listMhs[pos].umur);
            System.out.println("IPK\t : " + listMhs[pos].ipk);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public void sortByNim(int[] sortedNim) {
        Mahasiswa[] newList = new Mahasiswa[listMhs.length];
        for (int i = 0; i < listMhs.length; i++) {
            for (int j = 0; j < listMhs.length; j++) {
                if (sortedNim[i] == listMhs[j].nim) {
                    newList[i] = listMhs[j];
                    break;
                }
            }
        }
        listMhs = newList;
    }
}
