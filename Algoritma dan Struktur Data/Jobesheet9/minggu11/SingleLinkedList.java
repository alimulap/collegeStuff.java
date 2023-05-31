package minggu11;

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

    public void addFirst(int input) {
        Node ndInput = new Node(input, null);
        if (this.isEmpty()) {
            this.head = ndInput;
            this.tail = ndInput;
        } else {
            ndInput.next = this.head;
            this.head = ndInput;
        }
    }

    public void addLast(int input) {
        Node ndInput = new Node(input, null);
        if (this.isEmpty()) {
            this.head = ndInput;
            this.tail = ndInput;
        } else {
            this.tail.next = ndInput;
            this.tail = ndInput;
        }
    }

    public void insertAfter(int key, int input) {
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

    public void insertBefore(int key, int input) {
        Node ndInput = new Node(input, null);
        Node temp = head;
        if (temp.data == key) {
            ndInput.next = this.head;
            this.head = ndInput;
        }
        do {
            if (temp.next.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, int input) {
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

    public int getData(int index) {
        Node tmp = this.head;
        for (int i = 0; i < index; ++i) 
            tmp = tmp.next;
        return tmp.data;
    }

    public int indexOf(int key) {
        Node tmp = this.head;
        int index = 0;
        while (tmp != null && tmp.data != key) {
            tmp = tmp.next;
            ++index;
        }
        if (tmp == null)
            return -1;
        else
            return index;
    }

    public void removeFirst() {
        if (this.isEmpty())
            System.out.println("LinkedList masih kosong, tidak dapat menghapus elemen");
        else if (this.head == this.tail)
            this.head = this.tail = null;
        else
            this.head = this.head.next;
    } 

    public void removeLast() {
        if (this.isEmpty())
            System.out.println("LinkedList masih kosong, tidak dapat menghapus elemen");
        else if (this.head == this.tail)
            this.head = this.tail = null;
        else {
            Node temp = this.head;
            while (temp.next != this.tail)
                temp = temp.next;
            temp.next = null;
            this.tail = temp;
        }
    }

    public void remove(int key) {
        if (this.isEmpty())
            System.out.println("LinkedList masih kosong, tidak dapat menghapus elemen");
        else {
            Node temp = this.head;
            while (temp != null) {
                if ((temp.data == key) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.next.data == key) {
                    temp.next = temp.next.next;
                    if (temp.next == null)
                        this.tail = temp;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt(int index) {
        if (index == 0) 
            this.removeFirst();
        else {
            Node temp = this.head;
            for (int i = 0; i < index - 1; ++i) 
                temp = temp.next;
            temp.next = temp.next.next;
            if (temp.next == null)
                this.tail = temp;
        }
    }
}
