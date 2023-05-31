package Tugas;

public class Stack {
    int size, top;
    Struk data[];

    Stack(int size) {
        this.size = size;
        this.top = -1;
        this.data = new Struk[size];
    }

    public void push(Struk s) {
        if (top <= size -1)
            this.data[++this.top] = s;
        else
            System.out.println("Stack penuh");
    }

    public Struk pop() {
        if (this.top >= -1)
            return this.data[this.top--];
        else
            return null;
    }

    public void print() {
        for (int i = this.top; i >= 0; --i)
            this.data[i].print();
    }
}
