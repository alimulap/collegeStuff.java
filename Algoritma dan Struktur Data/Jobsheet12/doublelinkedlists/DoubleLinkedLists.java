package doublelinkedlists;

import java.net.Proxy;

class DoubleLinkedLists {
    Node head;
    int size;

    public DoubleLinkedLists() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(int item) {
        if (this.isEmpty())
            this.head = new Node(null, item, null);
        else {
            Node newNode = new Node(null, item, head);
            this.head.prev = newNode;
            this.head = newNode;
        }
        ++this.size;
    }

    public void addLast(int item) {
        if (this.isEmpty())
            addFirst(item);
        else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index) throws Exception {
        if (this.isEmpty())
            addFirst(item);
        else if (index < 0 || index > this.size) 
            throw new Exception("Nilai indeks di luar batas");
        else {
            Node current = this.head;
            int i = 0;
            while (i < index) {
                current = current.next;
                ++i;
            }
            if (current.prev == null) {
                Node newNode = new Node(null, item, current);
                current.prev = newNode;
                this.head = newNode;
            } else {
                Node newNode = new Node(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        ++this.size;
    }

    public void removeFirst() throws Exception {
        if (this.isEmpty()) 
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        else if (this.size == 1)
            this.removeLast();
        else {
            this.head = this.head.next;
            this.head.prev = null;
            --this.size;
        }
    }

    public void removeLast() throws Exception {
        if (this.isEmpty())
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        else if (this.head.next == null) {
            this.head = null;
            --this.size;
        } else {
            Node current = this.head;
            while (current.next.next != null) 
                current = current.next;
            current.next = null;
            --this.size;
        }
    }

    public void remove(int index) throws Exception {
        if (this.isEmpty() || index >= this.size)
            throw new Exception("Nilai index diluar batas");
        else if (index == 0)
            this.removeFirst();
        else {
            Node current = this.head;
            int i = 0;
            while (i < index) {
                current = current.next;
                ++i;
            }
            if (current.next == null)
                current.prev.next = null;
            else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                this.head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            --this.size;
        }
    }

    public int getFirst() throws Exception {
        if (this.isEmpty())
            throw new Exception("Linked List kosong");
        else return this.head.data;
    }

    public int getLast() throws Exception {
        if (this.isEmpty())
            throw new Exception("Linked List kosong");
        Node tmp = this.head;
        while (tmp.next != null) 
            tmp = tmp.next;
        return tmp.data;
    }

    public int get(int index) throws Exception {
        if (this.isEmpty())
            throw new Exception("Linked List Kosong");
        else if (index < 0 || index >= this.size)
            throw new Exception("Index di luar batas");
        Node tmp = this.head;
        for (int i = 0; i < index; ++i)
            tmp = tmp.next;
        return tmp.data;
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("Linked List Kosong.");
        else {
            Node tmp = this.head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nBerhasil diisi");
        }
    }
}
