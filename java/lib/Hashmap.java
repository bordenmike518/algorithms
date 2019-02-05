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
            return null;
        }
        Node node = this.hashmap[i];    
        while((String) node.getKey() != key) {
            node = node.getNext();
            if (node == null) {
                return null;
            }
        }
        return (V) node.getVal();
    }

    public boolean del(String key) {
        int i = index(key);
        if (this.hashmap[i] == null) {
            System.out.println("Hashmap() : ERROR key not in Hashmap.");
            return false;
        }
        Node prev = null;
        Node node = this.hashmap[i];
        while((String) node.getKey() != key) {
            prev = node;
            node = node.getNext();
            if (node == null)
                prev.setNext(null);
                return true;
        }
        prev.setNext(node.getNext());
        return true;
    }

    private int index(String key) {
        int acc = 0;
        for (char c: key.toCharArray())
             acc += (int) c;
        return acc % this.size;
    }
}
