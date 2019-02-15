/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Support class for mostCommonObject program. This is just an object
that holds two strings and compares if the two strings are the same as another
twoString objects strings.
*/

class twoString {
    public static String s1, s2;
    public twoString(String s1, String s2) {
        this.s1 = s1.toLowerCase();
        this.s2 = s2.toLowerCase();
    }
    
    public boolean compare(twoString other) {
        if (this.s1 == other.s1 && this.s2 == other.s2)
            return true;
        else
            return false;
    }
}

