package CustomLinkedListStereo;

class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E e, Node<E> next) {
        this.data = e;
        this.next = next;
        this.prev = prev;
    }

}
