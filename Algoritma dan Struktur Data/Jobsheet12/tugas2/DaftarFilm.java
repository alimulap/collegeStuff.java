package tugas2;

class Node {
    Film data;
    Node prev, next;

    Node(Node prev, Film data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

class DaftarFilm {
    private Node head;
    private int size;

    DaftarFilm() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean add(Film item, int index) {
        if (this.head == null) 
            this.head = new Node(null, item, null);
        else if (index < 0 || index > this.size) {
            System.out.println("Index salah");
            return false;
        }
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
        return true;
    }

    public boolean remove(int index) {
        if (this.head == null) 
            System.out.println("Daftar kosong");
        else if (index < 0 || index >= this.size) 
            System.out.println("Index salah");
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
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("-----------------------");
        System.out.println("Daftar Film Layar Lebar");
        System.out.println("-----------------------");
        Node current = this.head;
        while (current != null) {
            current.data.print();
            current = current.next;
        }
        System.out.println("\n");
    }

    public void cariFillm(int id) {
        Node current = this.head;
        int i = 0;
        while (current != null) {
            if (current.data.id == id) {
                System.out.println("Data dengan ID Film " + id + " berada pada node ke-" + (i+1) + "\nIdentitas:\n");
                current.data.print();
                return;
            }
            current = current.next;
            ++i;
        }
        System.out.println("Data dengan ID Film " + id + " tidak ditemukan didalam daftar film");
    }

    public void sortByRating() {
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            while (temp != null) {
                if (temp.data.rating > current.data.rating) {
                    Film tempData = current.data;
                    current.data = temp.data;
                    temp.data = tempData;
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }
}

