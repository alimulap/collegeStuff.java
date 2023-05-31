package tugas;

class SWLLMain {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push("Anto");
        st.push("Budi");
        st.push("Santi");
        st.push("Supardi");
        st.push("Yuni");
        st.push("Sinta");
        st.print();
        st.pop();
        st.pop();
        st.push("Tono");
        st.push("Nurhadi");
        st.print();
        st.pop();
        st.pop();
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

class Stack {
    Node head;
    Node tail;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void push(String input) {
        System.out.println(input + " mengantri");
        Node ndInput = new Node(input, null);
        if (this.isEmpty()) {
            this.head = ndInput;
            this.tail = ndInput;
        } else {
            ndInput.next = this.head;
            this.head = ndInput;
        }
    }

    public void pop() {
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

