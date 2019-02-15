/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Write a program that finds the most common object in an array of objects. Each object is a pair of strings. Treat strings as being the same if they are equal when converted to lower case.
*/
import java.util.Hashtable;
import java.util.Map;

class mostCommonObject {
    public static twoString mostCommonObject(twoString[] obs) {
        Hashtable<twoString, Integer> table = new Hashtable<>();
        for (twoString ts : obs) {
            if(!table.contains(ts))
                table.put(ts, 1);
            else
                table.put(ts, table.get(ts)+1);
        }
        twoString maxKey = null;
        int maxValue = 0;
        for(Map.Entry<twoString, Integer> entry : table.entrySet()) {
             if(entry.getValue() > maxValue) {
                 maxValue = entry.getValue();
                 maxKey = entry.getKey();
             }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        twoString[] ts1 = new twoString[8];
        ts1[0] = new twoString("apple", "candy");
        ts1[1] = new twoString("hello", "world");
        ts1[2] = new twoString("pick", "axis");
        ts1[3] = new twoString("candy", "apple");
        ts1[4] = new twoString("Hello", "WORLD");
        ts1[5] = new twoString("CANDY", "APPLE");
        ts1[6] = new twoString("apple", "CANDY");
        ts1[7] = new twoString("Hello", "wOrlD");
        twoString out1 = mostCommonObject(ts1);
        assert out1.compare(new twoString("hello", "world")): "mostCommonObject(): Fail";
        System.out.println("mostCommonObject(): Pass");
    }
}
