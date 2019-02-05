/*
Author  : Michael Borden
Date    : Feb 5, 2019
Update  : Feb 5, 2019

Purpose : Hashmap class which uses a list of linked lists.
*/
package lib;

public class Hashmap<V> {
    int size = 100;
    Node[] hashmap = new Node[size];
    
    public Hashmap() {
        for(int i = 0; i < this.size; i++)
            this.hashmap[i] = null;
    }

    public void put(String key, V value) {
        int i = index(key);
        if (this.hashmap[i] == null)
            this.hashmap[i] = new Node(key, value);
        else {
            Node node = this.hashmap[i];
            while(node.getNext() != null)
                node = node.getNext();
            node.setNext(new Node(key, value));
        }
    }

    public V get(String key) {
        int i = index(key);
        if (this.hashmap[i] == null) {
            System.out.println("Hashmap() : ERROR key not in Hashmap.");
            return null;  // return false?
        }
        Node node = this.hashmap[i];    
        while((String) node.getKey() != key) {
            node = node.getNext();
            if (node == null)
                break;
        }
        if (node != null)
            return (V) node.getVal();
        else
            return null;
    }

    public boolean del(String key) {   // Make boolean output for validity testing?
        int i = index(key);
        Node prev = null;
        if (this.hashmap[i] == null) {
            System.out.println("Hashmap() : ERROR key not in Hashmap.");
            return false;  // return false?
        }
        Node node = this.hashmap[i];
        while((String) node.getKey() != key) {
            prev = node;
            node = node.getNext();
            if (node == null)
                break;
        }
        if (node != null)
            prev.setNext(node.getNext());
        else
            prev.setNext(null);
        return true;
    }

    private int index(String key) {
        int acc = 0;
        for (char c: key.toCharArray())
             acc += (int) c;
        return acc % this.size;
    }
}
