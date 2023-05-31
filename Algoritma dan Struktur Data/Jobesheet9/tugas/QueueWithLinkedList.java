package tugas;

class QWLLMain {
    public static void main(String[] args) {
        Queue st = new Queue();
        st.enqueue("Anto");
        st.enqueue("Budi");
        st.enqueue("Santi");
        st.enqueue("Supardi");
        st.enqueue("Yuni");
        st.enqueue("Sinta");
        st.print();
        st.dequeue();
        st.dequeue();
        st.enqueue("Tono");
        st.enqueue("Nurhadi");
        st.print();
        st.dequeue();
        st.dequeue();
        st.print();
    }
}

class Node {
    String data;
    Node next;

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class Queue {
    Node head;
    Node tail;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(String input) {
        System.out.println(input + " mengantri");
        Node ndInput = new Node(input, null);
        if (this.isEmpty()) {
            this.head = ndInput;
            this.tail = ndInput;
        } else {
            this.tail.next = ndInput;
            this.tail = ndInput;
        }
    }

    public void dequeue() {
        if (this.isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Menandatangani KRS " + this.head.data);
        
        if (this.head == this.tail)
            this.head = this.tail = null;
        else 
            this.head = this.head.next;
    }

    public void peek() {
        if (this.isEmpty()) System.out.println("Antrian kosong.");
        else System.out.println("Mahasiswa terdepan: " + this.head.data);
    }


    public void print() {
        if (this.isEmpty())
            System.out.println("Antrian kosong.");
        else {
            Node tmp = head;
            System.out.print("Antrian mahasiswa:\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }
}

