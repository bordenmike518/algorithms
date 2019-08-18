/*
Author  : Michael Borden
Date    : May 22, 2019
Purpose : Show the difference between a traditional recursive algorithm, VS a 
recursive alogrithm using dynamic programming.
*/

import java.util.HashMap;

public class HelloWorld{
    static int x1, x2;
    static {
        x1 = 0;
        x2 = 0;
    }
    public static long count1(long r, long c, long n) {
        x1 += 1;
        if (r == n) 
            return 1;
        if (c == n) 
            return 1;
        return count1(r+1,c,n) + count1(r,c+1,n);
    }
    public static long count2 (long r, long c, long n) {
        HashMap<String, Long> hm = new HashMap<>();
        return count(r, c, n, hm);
    }
    public static long count(long r, long c, long n, HashMap<String, Long> hm) {
        x2 += 1;
        if (r == n) 
            return 1;
        if (c == n) 
            return 1;
        String key = String.format("%d,%d", r, c);
        if (hm.containsKey(key))
            return hm.get(key);
        else {
            long x = count(r+1,c,n,hm) + count(r,c+1,n,hm);
            hm.put(key, x);
            return hm.get(key);
        }
    }
    public static void main(String []args){
        System.out.println(count1(0, 0, 4));
        System.out.println(x1);
        System.out.println(count2(0, 0, 4));
        System.out.println(x2);
    }
}
