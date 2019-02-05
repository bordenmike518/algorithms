/*
Author  : Michael Borden
Date    : Feb 5, 2019
Update  : Feb 5, 2019

Purpose : Single link key value Node class.
*/
package lib;

public class Node<K,V> {
    private Node next;
    private K key;
    private V val;
    
    public Node(K key, V val) {
        this(key, val, null);
    }

    public Node(K key, V val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public Node getNext() {
        return this.next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return this.key;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public V getVal() {
        return this.val;
    }
}
