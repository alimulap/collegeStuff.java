package praktikum1;

class DequeueResult {
    public boolean success;
    public int value;
    public DequeueResult(boolean s, int v){
        this.success = s;
        this.value = v;
    }
}

class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    Queue(int n){
        this.max = n;
        this.data = new int[this.max];
        this.size = 0;
        this.front = this.rear = -1;
    }
    
    boolean isEmpty(){
        return this.size == 0;
    }

    boolean isFull(){
        return this.size == this.max;
    }

    boolean enqueue(int dt){
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
        int dt = 0;
        if (this.isEmpty()) {
            System.out.println("Queue masih kosong");
            return new DequeueResult(false, dt);
        }
        else {
            dt = this.data[this.front];
            this.size++;
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
            System.out.println("Elemen terdepan: " + this.data[this.front]);
        else 
            System.out.println("Queue kosong");
    }

    void peekRear() {
        if (!this.isEmpty())
            System.out.println("Elemen terbelakang: " + this.data[this.rear]);
        else 
            System.out.println("Queue kosong");
    }

    void print(){
        if (!this.isEmpty())
            System.out.println("Queue masih kosong");
        else {
            int i = front;
            while (i != rear) {
                System.out.print(this.data[i] + " ");
                i = (i + 1) % this.max;
            }
            System.out.println(this.data[i] + " ");
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
