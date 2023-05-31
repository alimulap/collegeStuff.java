package BengkelMobil;

class NodeLayanan {
    Layanan data;
    NodeLayanan next;

    NodeLayanan(Layanan data, NodeLayanan next) {
        this.data = data;
        this.next = next;
    }
}

class DaftarLayanan {
    NodeLayanan head, tail;
    int size, totalPemasukan;

    DaftarLayanan() {
        this.head = null;
        this.size = 0;
        this.totalPemasukan = 0;
    }

    void add(Layanan baru) {
        NodeLayanan newNode = new NodeLayanan(baru, null);
        if (this.size == 0)
            this.head = this.tail = newNode;
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        ++this.size;
        this.totalPemasukan += newNode.data.harga;
        System.out.println("Layanan berhasil ditambahkan");
    }

    void print() {
        if (this.size == 0) 
            System.out.println("Daftar kosong.");
        else {
            NodeLayanan current = this.head;
            int hitung = 0;
            System.out.println(
                "---------------------------------\n" +
                "Daftar layanan: \n" +
                "---------------------------------"
            );
            while (current != null) {
                System.out.println(
                    ++hitung + "\t nama: " + current.data.namaLayanan + 
                    "\n\t kode: " + current.data.kodeLayanan + 
                    "\n\t harga: " + current.data.harga
                );
                current = current.next;
            }
            System.out.println("---------------------------------");
        }
    }

    void sort() {
        if (this.size == 0)
            System.out.println("Laporan kosong.");
        else if (this.size == 1)
            return;
        else {
            boolean swapped;
            do {
                swapped = false;
                for (NodeLayanan current = this.head; current.next != null; current = current.next) {
                    if (current.data.harga < current.next.data.harga) {
                        Layanan temp = current.data;
                        current.data = current.next.data;
                        current.next.data = temp;
                        swapped = true;
                    }
                }
            } while (swapped);
        }
    }

    void laporan() {
        this.sort();
        this.print();
        System.out.println(
            "Total pemasukan: " + this.totalPemasukan + "\n" + 
            "---------------------------------\n"
        );
    }
}
