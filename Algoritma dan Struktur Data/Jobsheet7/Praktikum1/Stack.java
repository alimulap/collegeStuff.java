package Praktikum1;

public class Stack {
    int size;
    int top;
    Pakaian[] data;

    Stack(int size) {
        this.size = size;
        this.data = new Pakaian[size];
        this.top = -1;
    }
    
    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.size - 1;
    }

    public void push(Pakaian e) {
        if (!this.isFull()) 
            this.data[++this.top] = e;
        else
            System.out.println("Isi stack sudah penuh.");
    }

    public void pop() {
        if (!this.isEmpty()) {
            Pakaian x = this.data[this.top--];
            System.out.println(
                    "Data yang keluar: " + 
                    x.jenis + " " + 
                    x.warna + " " + 
                    x.merk + " " + 
                    x.ukuran + " " + 
                    x.harga );
        } else {
            System.out.println("Stack masih kosong.");
        }
    }
    
    public void peek() {
        if (!this.isEmpty())
            System.out.println(
                    "Elemen teratas: " + 
                    this.data[this.top].jenis + " " +
                    this.data[this.top].warna + " " +
                    this.data[this.top].merk + " " +
                    this.data[this.top].ukuran + " " +
                    this.data[this.top].harga );
        else
            System.out.println("Stack kosong.");
    }

    public void print() {
        System.out.println("Isi stack: ");
        for (int i = this.top; i >= 0; --i) {
            System.out.println(
                    this.data[i].jenis + " " +
                    this.data[i].warna + " " +
                    this.data[i].merk + " " +
                    this.data[i].ukuran + " " +
                    this.data[i].harga );
            System.out.println();
        }
    }

    public void clear() {
        if (!this.isEmpty()) {
            while (this.top >= 0)
                this.top--;
            System.out.println("Stack sudah dikosongkan");
        }
        else
            System.out.println("Pakaian sudah kosong.");
    }

    public void getMin() {
        Pakaian min = this.data[this.top];
        for (int i = this.top - 1; i >= 0; --i)
            if (this.data[i].harga < min.harga)
                min = this.data[i];
        System.out.println(
                "Pakaian dengan harga terendah adalah: " + 
                min.jenis + " " + 
                min.warna + " " + 
                min.merk + " " + 
                min.ukuran + " " + 
                min.harga );
    }
}
