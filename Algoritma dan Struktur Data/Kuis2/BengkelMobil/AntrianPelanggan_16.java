package BengkelMobil;

class Node {
    Pelanggan data;
    Node next;

    Node(Pelanggan data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class AntrianPelanggan {
    Node front, rear;
    int size;

    AntrianPelanggan() {
        this.front = this.rear = null;
        this.size = 0;
    }

    void enqueue(Pelanggan baru) {
        Node newNode = new Node(baru, null);
        if (this.size == 0)
            this.front = this.rear = newNode;
        else {
            this.rear.next = newNode;
            this.rear = newNode;
        }

        ++this.size;

        System.out.println("Antrian berhasil ditambahkan");
    }

    int dequeue() {
        if (this.size == 0) {
            System.out.println("Antrian kosong.");
            return 1;
        } else {
            System.out.println("Pelanggan " + this.front.data.namaPelanggan + " dilayani");
            if (this.size == 1)
                this.front = this.rear = null;
            else
                this.front = this.front.next;
            return 0;
        }
    }

    void print() {
        if (this.size == 0) 
            System.out.println("Antrian kosong.");
        else {
            Node current = this.front;
            int hitung = 0;
            System.out.println(
                "---------------------------------\n" +
                "Anrian pelanggan: \n" +
                "---------------------------------"
            );
            while (current != null) {
                System.out.println(
                    ++hitung + "\t nama: " + current.data.namaPelanggan + 
                    "\n\t noHP: " + current.data.noHP
                );
                current = current.next;
            }
            System.out.println("---------------------------------");
        }
    }
}

