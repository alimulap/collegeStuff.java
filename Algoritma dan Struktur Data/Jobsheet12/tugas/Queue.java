package tugas;

class Node {
    PenerimaVaksin data;
    Node next, prev;

    Node(Node prev, PenerimaVaksin data, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class Queue {
    Node head, tail;
    int size;

    Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(PenerimaVaksin input) {
        if (this.head == null) {
            this.head = new Node(null, input, null);
            this.tail = this.head;
        } else {
            Node newNode = new Node(this.tail, input, null);
            this.tail.next = newNode;
            this.tail = newNode;
        }
        ++this.size;
    }

    public void dequeue() {
        if (this.head == null)
            System.out.println("Antrian kosong.");
        else {
            System.out.println(this.head.data.nama + " telah selesai divaksinasi.");
            this.head.next.prev = null;
            this.head = this.head.next;
            --this.size;
            this.print();
        }
    }

    public void print() {
        System.out.println("+++++++++++++++++++++++");
        System.out.println("Daftar Pengantri Vaksin");
        System.out.println("+++++++++++++++++++++++");
        System.out.println("|No.\t|Nama.\t|");
        Node current = this.head;
        while (current != this.tail) {
            System.out.println("|" + current.data.nomor + "\t|" + current.data.nama + "\t|");
            current = current.next;
        }
        System.out.println("|" + current.data.nomor + "\t|" + current.data.nama + "\t|");
        System.out.println("Sisa Antrian: " + this.size);
    }
}
