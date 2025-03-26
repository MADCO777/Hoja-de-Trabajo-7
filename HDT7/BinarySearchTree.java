package HDT7;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E data;
        Node left;
        Node right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Método para insertar un elemento
    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, E data) {
        if (root == null) {
            return new Node(data);
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Método para buscar un elemento
    public E search(E key) {
        return searchRec(root, key);
    }

    private E searchRec(Node root, E key) {
        if (root == null || root.data.compareTo(key) == 0) {
            return root != null ? root.data : null;
        }
        if (key.compareTo(root.data) < 0) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }
}