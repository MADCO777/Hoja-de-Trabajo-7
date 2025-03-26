package HDT7;

class Node<E> {
    E data;
    Node<E> left, right;

    public Node(E item) {
        data = item;
        left = right = null;
    }
}