package praktikum2;

class DequeueResult {
    public boolean success;
    public Nasabah value;
    public DequeueResult(boolean s, Nasabah v){
        this.success = s;
        this.value = v;
    }
}

class Queue {
    Nasabah[] data;
    int front;
    int rear;
    int size;
    int max;

    Queue(int n){
        this.max = n;
        this.data = new Nasabah[this.max];
        this.size = 0;
        this.front = this.rear = -1;
    }
    
    boolean isEmpty(){
        return this.size == 0;
    }

    boolean isFull(){
        return this.size == this.max;
    }

    boolean enqueue(Nasabah dt){
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
        Nasabah dt = new Nasabah();
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
                                this.data[this.front].norek + " " +
                                this.data[this.front].nama + " " +
                                this.data[this.front].alamat + " " +
                                this.data[this.front].umur + " " +
                                this.data[this.front].saldo);
        else 
            System.out.println("Queue masih kosong");
    }

    void peekRear() {
        if (!this.isEmpty())  
            System.out.println("Elemen terbelakang: " + 
                                this.data[this.rear].norek + " " +
                                this.data[this.rear].nama + " " +
                                this.data[this.rear].alamat + " " +
                                this.data[this.rear].umur + " " +
                                this.data[this.rear].saldo);
        else 
            System.out.println("Queue kosong");
    }

    void print(){
        if (this.isEmpty())
            System.out.println("Queue masih kosong");
        else {
            int i = front;
            while (i != rear) {
                System.out.println(this.data[this.front].norek + " " +
                                   this.data[this.front].nama + " " +
                                   this.data[this.front].alamat + " " +
                                   this.data[this.front].umur + " " +
                                   this.data[this.front].saldo);
                i = (i + 1) % this.max;
            }
            System.out.println(this.data[i].norek + " " +
                               this.data[i].nama + " " +
                               this.data[i].alamat + " " +
                               this.data[i].umur + " " +
                               this.data[i].saldo);
            System.out.println("Jumlah elemen = " + this.size);
        }
    }

    void clear(){
        if (!this.isEmpty()) {
            this.front = this.rear = -1;
            this.size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }
}
