package BTreeSearchLS;

class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    boolean isEmpty() {
        return this.root == null;
    }

    void add(int data) {
        if (this.isEmpty())
            this.root = new Node(data);
        else {
            Node current = this.root;
            while (true) {
                if (data < current.data) {
                    if (current.left != null)
                        current = current.left;
                    else {
                        current.left = new Node(data);
                        break;
                    }
                } else if (data > current.data) {
                    if (current.right != null)
                        current = current.right;
                    else {
                        current.right = new Node(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    void addRecurse(int data, Node current) {
        if (current == this.root)
            this.root = new Node(data);
        else {
            if (data < current.data) {
                if (current.left != null)
                    this.addRecurse(data, current.left);
                else 
                    current.left = new Node(data);
            } else if (data > current.data) {
                if (current.right != null)
                    this.addRecurse(data, current.right);
                else 
                    current.right = new Node(data);
            }
        }
    }

    void findBiggestAndSmallest() {
        if (this.isEmpty())
            System.out.println("Binary Tree is empty.");
        else {
            this.findSmallest();
            this.findBiggest();
        }
    }

    void findSmallest() {
        Node current = this.root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("Smallest: " + current.data);
    }

    void findBiggest() {
        Node current = this.root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Biggest: " + current.data);
    }

    void displayAllLeaf(Node current) {
        if (current == null)
            return;
        else if (current.left == null && current.right == null)
            System.out.println(current.data + " ");
        else {
            displayAllLeaf(current.left);
            displayAllLeaf(current.right);
        }
    }

    int countAllLeaf(Node current) {
        if (current == null)
            return 0;
        else if (current.left == null && current.right == null)
            return 1;
        else {
            return countAllLeaf(current.left) + countAllLeaf(current.right);
        }
    }

    boolean find(int data) {
        boolean hasil = false;
        Node current = this.root;
        while (this.root != null) {
            if (current.data == data) {
                hasil = true;
                break;
            } else if (data < current.data) 
                current = current.left;
            else if (data > current.data) 
                current = current.right;
        }
        return hasil;
    }

    void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    Node getSuccessor(Node del) {
        Node successor = del.right;
        Node successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data) {
        if (this.isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }

        Node parent = this.root;
        Node current = this.root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data == data)
                break;
            else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (data > current.data) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == this.root)
                    this.root = null;
                else {
                    if (isLeftChild)
                        parent.left = null;
                    else
                        parent.right = null;
                }
            } else if (current.left == null) {
                if (current == this.root) 
                    this.root = current.right;
                else {
                    if (isLeftChild)
                        parent.left = current.right;
                    else 
                        parent.right = current.right;
                }
            } else if (current.right == null) {
                if (current == this.root) 
                    this.root = current.left;
                else {
                    if (isLeftChild)
                        parent.left = current.left;
                    else 
                        parent.right = current.left;
                }
            } else {
                Node successor = this.getSuccessor(current);
                if (current == this.root) 
                    this.root = successor;
                else {
                    if (isLeftChild) 
                        parent.left = successor;
                    else 
                        parent.right = successor;
                    successor.left = current.left;
                }
            }
        }
    }
}
