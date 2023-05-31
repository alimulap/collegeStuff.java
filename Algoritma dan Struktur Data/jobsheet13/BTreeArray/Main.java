package BTreeArray;

class Main {
    public static void main(String[] args) {
        BinaryTreeArray bta = new BinaryTreeArray();

        int[] data = { 6, 4, 8, 3, 5, 7, 9, 0, 0, 0};
        int idxlast = 6;

        bta.populateData(data, idxlast);
        bta.traverseInOrder(0);
    }
}

