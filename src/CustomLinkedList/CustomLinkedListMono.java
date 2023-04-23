package CustomLinkedList;

public class CustomLinkedListMono<E> {
    Node<E> first;
    int size = 0;

    public int getSize() {
        return size;
    }

    public CustomLinkedListMono() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void removeFirst() {
        Node<E> tempNode = first;
        first = first.next;
        size--;
    }

    public Node<E> find(E item) {
        Node<E> current = first;
        while (current.data != item) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }

    public void remove(E item) {
        Node<E> current = first;
        Node<E> previous = first;
        while (current.data != item) {
            if (current.next == null) {
                break;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
            size--;
        } else {
            previous.next = current.next;
            size--;
        }
    }

    public void displayList() {
        Node<E> current = first;
        while(current != null){
            System.out.println(current.getData());
            current = current.next;
        }
        System.out.println("");
    }

    Node<E> node(int index) {
        Node<E> current = this.first;
        for(int i = 0; i <= index; i++ ){
            if (i==index){
                break;
            }
            current = current.next;
        }
        return current;
    }

    public E get(int index) {
        if(index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return node(index).data;
    }

    void addLast(E data) {
        if (first == null){
            addFirst(data);
        } else {
            Node<E> current = first;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data);
            size++;
        }
    }

    public boolean add(E e){
        addLast(e);
        return true;
    }

    public boolean add(int index, E e) {
        Node<E> current = node(index);
        Node<E> previous = first;
        while (previous.next != current) {
            previous = previous.next;
        }
        Node<E> newNode = new Node<>(e);
        previous.next = newNode;
        newNode.next = current;
        return true;
    }
}
