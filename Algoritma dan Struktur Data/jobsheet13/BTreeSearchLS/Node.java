package BTreeSearchLS;

class Node {
    int data;
    Node left, right;

    Node() { }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
