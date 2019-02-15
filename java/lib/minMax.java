/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Write a function that takes a simple list of numbers as a parameter and returns a list with the largest and smallest numbers in the given list.
*/

class minMax {
    
    public static <T extends Number> double[] minMax(T[] numList) {
        double min =  1<<30;
        double max = -1<<30;
        double buff = 0.0;
        for(T x : numList) {
            buff = x.doubleValue();
            if (buff < min)
                min = buff;
            if (buff > max)
                max = buff;
        }
        return new double[] {min, max};
    }

    public static void main(String[] args) {
        Integer[] arr1 = {0, 1, 2, 3, 0, 0, 9374, 920, 0, 0, 12, 42};
        Double[] arr2 = {0.0, 0.3, 20.3, 0.0, 0.0, -2.5, 4.2, 0.0001};
        double[] mm1 = minMax(arr1);
        double[] mm2 = minMax(arr2);
        assert mm1[0] == 0.0 && mm1[1] == 9374.0: "minMax(): Fail";
        assert mm2[0] == -2.5 && mm2[1] == 20.3: "minMax(): Fail";
        System.out.println("minMax(): Pass");
    }
}
