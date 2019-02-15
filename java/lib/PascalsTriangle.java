/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Write a function that takes an integer n as a parameter and prints the first n rows of the Pascal's triangle.
*/

class PascalsTriangle {
    
    public static void PascalsTriangle(int n) {
        String row;
        int m = n;
        for(int i = 0; i < n; i++) {
            row = "";
            for (int j = 0; j < m; j++)
                row += " ";
            for (int k = 0; k < i+1; k++)
                row += "* ";
            m -= 1;
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        PascalsTriangle(Integer.parseInt(args[0]));
    }
}
