/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Arrays: Write a program that tests if a 2D square array is symmetric about the diagonal from (0,0) to (n-1,n-1).
*/

class symmetricMatrices {
    
    public static <T extends Number> boolean symmetricMatrices(T[][] A) {
        int l = A.length;
        if (A[0].length != l)
            return false;
        int i = 0, j = 1;
        while (i < l-1) {
            while (j < l) {
                if (A[i][j] != A[j][i])
                    return false;
                j += 1;
            }
            i += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[][]    m1 = {{1,2,3}, {2,6,9}, {3,9,0}};
        Double[][] m2 = {{1.2,4.0,3.0}, {2.3,6.0,9.0}, {3.0,8.66,0.0}};
        boolean mb1 = symmetricMatrices(m1);
        boolean mb2 = symmetricMatrices(m2);
        assert !mb1: "symmetricMatrices(): Fail";
        assert mb2: "symmetricMatrices(): Fail";
        System.out.println("symmetricMatrices(): Pass");
    }
}
