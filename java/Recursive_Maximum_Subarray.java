import java.util.*;

class Tuple {
    int low, high, sum;
    public Tuple(int low, int high, int sum) {
        this.low = low;
        this.high = high;
        this.sum = sum;
    }
    public void print() {
        System.out.println("Low  : " + this.low);
        System.out.println("High : " + this.high);
        System.out.println("Sum  : " + this.sum);
    }
}

class Recursive_Maximum_Subarray {

    /* Exercise 3: Returns the non-empy contiguous sublist with largest sum. */
    public static Tuple maximum_subarray(int[] A, int low, int high) {
        if (low == high) 
            return new Tuple(low, high, A[low]);
        int mid = (int) Math.floor((low + high) / 2);
        Tuple left = maximum_subarray(A, low, mid);
        Tuple right = maximum_subarray(A, mid+1, high);
        Tuple cross = maximum_crossing_subarray(A, low, mid, high);
        if (left.sum >= right.sum && left.sum >= cross.sum)
            return left;
        if (right.sum >= right.sum && right.sum >= cross.sum)
            return right;
        else
            return cross;
    }
    
    public static Tuple maximum_crossing_subarray(int[] A, int low, int mid, int high) {
        int left_sum = -(1 << 31);
        int sum = 0;
        int max_left = 0;
        for (int i = mid; i >= low; --i) {
            sum += A[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        int right_sum = -(1 << 31);
        sum = 0;
        int max_right = 0;
        for (int j = mid+1; j <= high; ++j) {
            sum += A[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        return new Tuple(max_left, max_right, left_sum + right_sum);
    }

    public static void main(String[] args) {
        /* Exercise 3 */
        int[] A = {1, -3, 4, -9, 3, 6, 2, -4, 5, -7, 3, -6, 8};
        Tuple answer = maximum_subarray(A, 0, A.length-1);
        answer.print();
        /* Exercise  */
    }
}
