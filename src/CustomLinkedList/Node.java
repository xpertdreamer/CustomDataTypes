package CustomLinkedList;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data){
        this.data = data;
        next = null;
    }

    public E getData(){
        return data;
    }
}
