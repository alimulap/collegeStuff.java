package BTreeArray;

class BinaryTreeArray {
    int[] data;
    int idxlast;

    public BinaryTreeArray() {
        this.data = new int[10];
    }

    void populateData(int data[], int idxlast) {
        this.data = data;
        this.idxlast = idxlast;
    }

    void add(int data) {
        if (this.idxlast == this.data.length - 1)
            System.out.println("Binary Tree is full");
        else
            this.data[this.idxlast++] = data;
    }

    void traverseInOrder(int idxstart) {
        if (idxstart <= idxlast) {
            traverseInOrder(2 * idxstart + 1);
            System.out.print(this.data[idxstart] + " ");
            traverseInOrder(2 * idxstart + 2);
        }
    }

    void traversePreOrder(int idxstart) {
        if (idxstart <= idxlast) {
            System.out.print(this.data[idxstart] + " ");
            traversePreOrder(2 * idxstart + 1);
            traversePreOrder(2 * idxstart + 2);
        }
    }

    void traversePostOrder(int idxstart) {
        if (idxstart <= idxlast) {
            traversePostOrder(2 * idxstart + 1);
            traversePostOrder(2 * idxstart + 2);
            System.out.print(this.data[idxstart] + " ");
        }
    }
}
