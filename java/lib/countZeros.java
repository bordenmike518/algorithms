/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Write a function that returns the number of zeros in a given simple list of numbers.
*/

class countZeros {
    
    public static <T extends Number> long countZeros(T[] numList) {
        long acc = 0;
        for(Number x : numList) {
            if (x.doubleValue() == 0.00) {
                acc += 1;
            }
        }
        return acc;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {0, 1, 2, 3, 0, 0, 9374, 920, 0, 0, 12, 42};
        Double[] arr2 = {0.0, 0.3, 20.3, 0.0, 0.0, 2.5, 4.2, 0.0001};
        long zeroCount1 = countZeros(arr1);
        long zeroCount2 = countZeros(arr2);
        assert zeroCount1 == 5: "countZeros(): Fail";
        assert zeroCount2 == 3: "countZeros(): Fail";
        System.out.println("countZeros(): Pass");
    }
}
