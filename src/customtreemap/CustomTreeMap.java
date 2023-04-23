package customtreemap;

public class CustomTreeMap<K, V> {
    //create a root node and size counter
    private Node root = null;
    private int size = 0;
    //class for node
    class Node {
        public K key;
        public V value;
        public Node left = null;
        public Node right = null;
        //node constructor
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    //size getter
    public int size() {
        return size;
    }
    //check if tree is empty
    public boolean isEmpty() {
        return size == 0;
    }
    //getter of objects
    public V get(K key) {
        Node node = findNode(key);
        if (node == null) { return null; }
        return node.value;
    }
    //function which help method "get" to find a node by key
    private Node findNode(K key) throws NullPointerException{
        if (key == null) {
            throw new NullPointerException();
        }
        Comparable<? super K> k = (Comparable<? super K>) key;
        Node node = root;
        while (node != null) {
            int cmp = k.compareTo(node.key);
            if(cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }
    //function for putting objects to TreeMap with key and value
    public V put(K key, V value) throws NullPointerException{
        if (key == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            root = new Node(key, value);
            size++;
            return value;
        }
        return putHelper(root, key, value);
    }
    //function which help method "put" to compare objects and keys
    private V putHelper(Node node, K key, V value) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        int cmp = k.compareTo(node.key);
        if(cmp < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.left, key, value);
            }
        }
        if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.right, key, value);
            }
        }
        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }
    //remove elements from collection by key
    public V remove(K key) {
        V value = get(key);
        root = removeRecursive(key);
        return value;
    }
    //function which help method "remove" compare and delete elements
    private Node removeRecursive(K key) {
        Node node = findNode(key);
        if (node.left == null && node.right == null) {
            node = null;
            size--;
            return node;
        }
        if (node.right == null) {
            node = node.left;
            size--;
            return node;
        }
        if (node.left == null) {
            node = node.right;
            size--;
            return node;
        }
        node = findSmallestValue(node.right);
        size--;
        return node;
    }
    //func to find the smallest value of tree
    private Node findSmallestValue(Node root) {
        return root.left == null ? root : findSmallestValue(root.left);
    }
    //func to clear a tree
    public void clear(){
        size = 0;
        root = null;
    }
}
