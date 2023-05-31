package tugas;

class Main {
    public static void main(String[] args) {
        SingleLinkedList singLL = new SingleLinkedList();
        singLL.print();
        singLL.addFirst('c');
        singLL.print();
        singLL.addFirst('a');
        singLL.print();
        singLL.addLast('e');
        singLL.print();
        singLL.insertAfter('a', 'b');
        singLL.print();
        singLL.insertAt(3, 'd');
        singLL.print();
    }
}

class Node {
    char data;
    Node next;

    Node(char nilai, Node berikutnya) {
        this.data = nilai;
        this.next = berikutnya;
    }
}

class SingleLinkedList {
    Node head;
    Node tail;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void print() {
        if (!this.isEmpty()) {
            Node tmp = head;
            System.out.print("Isi Linked List:\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println();
        } else {
            System.out.println("Linked List kosong");
        }
    }

    public void addFirst(char input) {
        Node ndInput = new Node(input, null);
        if (this.isEmpty()) {
            this.head = ndInput;
            this.tail = ndInput;
        } else {
            ndInput.next = this.head;
            this.head = ndInput;
        }
    }

    public void addLast(char input) {
        Node ndInput = new Node(input, null);
        if (this.isEmpty()) {
            this.head = ndInput;
            this.tail = ndInput;
        } else {
            this.tail.next = ndInput;
            this.tail = ndInput;
        }
    }

    public void insertAfter(char key, char input) {
        Node ndInput = new Node(input, null);
        Node temp = head;
        do {
            if (temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) this.tail = ndInput;
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, char input) {
        if (index < 0) {
            System.out.println("index salah");
        } else if (index == 0) {
            this.addFirst(input);
        } else {
            Node temp = this.head;
            for (int i = 0; i < index -1; ++i) 
                temp = temp.next;
            temp.next = new Node(input, temp.next);
            if (temp.next == null) this.tail = temp.next;
        }
    }
}

