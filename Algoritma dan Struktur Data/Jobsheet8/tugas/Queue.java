package tugas;

class DequeueResult {
    public boolean success;
    public Pembeli value;
    public DequeueResult(boolean s, Pembeli v){
        this.success = s;
        this.value = v;
    }
}

class Queue {
    Pembeli[] data;
    int front;
    int rear;
    int size;
    int max;

    Queue(int n){
        this.max = n;
        this.data = new Pembeli[this.max];
        this.size = 0;
        this.front = this.rear = -1;
    }
    
    boolean isEmpty(){
        return this.size == 0;
    }

    boolean isFull(){
        return this.size == this.max;
    }

    boolean enqueue(Pembeli dt){
        if (this.isFull()) {
            System.out.println("Queue sudah penuh");
            return false;
        }
        else {
            if (this.isEmpty())
                this.front = this.rear = 0;
            else {
                if (this.rear == this.max-1)
                    this.rear = 0;
                else 
                    this.rear++;
            }
            this.data[this.rear] = dt;
            this.size++;
            return true;
        }
    }

    DequeueResult dequeue(){
        Pembeli dt = new Pembeli();
        if (this.isEmpty()) {
            System.out.println("Queue kosong");
            return new DequeueResult(false, dt);
        }
        else {
            dt = this.data[this.front];
            this.size--;
            if (this.isEmpty())
                this.front = this.rear = -1;
            else {
                if (this.front == this.max-1)
                    this.front = 0;
                else 
                    this.front++;
            }
            return new DequeueResult(true, dt);
        }
    }

    void peek(){
        if (!this.isEmpty())  
            System.out.println("Elemen terdepan: " + 
                                this.data[this.front].nama + " " +
                                this.data[this.front].noHP);
        else 
            System.out.println("Queue masih kosong");
    }

    void peekRear() {
        if (!this.isEmpty())  
            System.out.println("Elemen terbelakang: " + 
                                this.data[this.front].nama + " " +
                                this.data[this.front].noHP);
        else 
            System.out.println("Queue kosong");
    }
    
    void peekPosition(String nama) {
        if (this.isEmpty()) {
            System.out.println("Queue kosong");
            return;
        }
        else {
            int i = front;
            int posisi = 1;
            while (i != rear) {
                if (this.data[i].nama.equals(nama)) {
                    System.out.println(nama + " berada pada posisi " + posisi);
                    return;
                }
                i = (i + 1) % this.max;
                posisi++;
            }
            if (this.data[i].nama.equals(nama)) {
                System.out.println(nama + " berada pada posisi " + posisi);
                return;
            }
        }
        System.out.println(nama + " tidak berada dalam antrian");
    }

    void daftarPembeli() {
        if (this.isEmpty())
            System.out.println("Queue masih kosong");
        else {
            int i = front;
            while (i != rear) {
                System.out.println(this.data[this.front].nama + " " +
                                   this.data[this.front].noHP);
                i = (i + 1) % this.max;
            }
                System.out.println(this.data[this.front].nama + " " +
                                   this.data[this.front].noHP);
            System.out.println("Jumlah elemen = " + this.size);
        }
    }

    void print(){
        if (this.isEmpty())
            System.out.println("Queue masih kosong");
        else {
            int i = front;
            while (i != rear) {
                System.out.println(this.data[this.front].nama + " " +
                                   this.data[this.front].noHP);
                i = (i + 1) % this.max;
            }
                System.out.println(this.data[this.front].nama + " " +
                                   this.data[this.front].noHP);
            System.out.println("Jumlah elemen = " + this.size);
        }
    }
}
