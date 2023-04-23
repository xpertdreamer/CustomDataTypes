package CustomLinkedListStereo;

public class CustomLinkedList<E> {
    Node<E> first;
    Node<E> last;
    int size = 0;

    public int getSize() {
        return size;
    }

    public CustomLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void linkFirst(E data) {
        Node<E> temp = last;
        Node<E> newNode = new Node<>(temp, data, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        }else {
            temp.next = newNode;
        }
        size++;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
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

    E unlink(Node<E> x) {
        final E element = x.data;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        x.data = null;
        size--;
        return element;
    }

    public void displayList() {
        Node<E> current = first;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("");
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    private boolean isElementIndex(int index) {
        return index >=0 && index < size;
    }

    void linkLast(E data) {
        Node<E> temp = first;
        Node<E> newNode = new Node<>(temp, data, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    void linkBefore(E data, Node<E> succ) {
        Node<E> pre = succ.prev;
        Node<E> newNode = new Node<>(pre, data, succ);
        succ.prev = newNode;
        if (pre == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }
        size++;
    }

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    public void add(int index, E e) {
        checkElementIndex(index);
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, node(index));
        }
    }
}
