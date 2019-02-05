/*
Author  : Michael Borden
Date    : Feb 5, 2019
Update  : Feb 5, 2019

Purpose : To test the Node and Hashmap classes.
*/
import lib.Node;
import lib.Hashmap;

class HashmapTest {
    public static void main(String[] args) {
        Hashmap hm = new Hashmap();
        // Test cases
        hm.put("Mike", 10001);
        hm.put("Miek", 12345);
        hm.put("Mkie", "New York"); // To check that different types work
        // Testing
        if((int) hm.get("Mike") != 10001)
            System.out.println("Hashmap() : fail at key = Mike");
        else if((int) hm.get("Miek") != 12345)
            System.out.println("Hashmap() : fail at key = Miek");
        else if((String) hm.get("Mkie") != "New York")
            System.out.println("Hashmap() : fail at key = Mkie");
        else
            System.out.println("HashmapTest() : Pass\n --Node()\n --Hashmap()");
    }
}







