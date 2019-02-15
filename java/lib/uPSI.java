/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Write a program to find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0, where each "_" is a single digit.
*/
import java.lang.Math;
import java.lang.Thread;



public class uPSI {
    public static volatile boolean flag = true;
    
    static class mtUPSI extends Thread {
        public long tid, m, v;
        public mtUPSI(int tid, long v) {
            this.tid = tid;
            this.m = v*tid;
            this.v = v;
        }
        
        public void run() {
            try {
                System.out.println(String.format("Thread id is %d", this.tid)); 
                long n = 1234567890L;
                double x, y, yy;
                long b1 = 0L, b2 = 0L;
                do {
                    x = 0;
                    b1 = n;
                    b2 = this.m;
                    for (int i = 0; i <= 10; i++) {
                        x += (double) ((b1%10)*Math.pow(10, i*2));
                        x += (double) ((b2%10)*Math.pow(10, i*2+1));
                        b1 /= 10L;
                        b2 /= 10L;
                    }
                    this.m += 1;
                    y = Math.sqrt(x);
                    yy = Math.pow(y, 2);
                    if (this.m % 10000000 == 0) {
                        System.out.println(
                            String.format("Thread %d is at %d", this.tid, this.m)
                        );
                    }
                } while (uPSI.flag && y % 1 == 0.0 && this.m < (this.m + this.v));
                if (uPSI.flag) {
                    System.out.println(
                        String.format("Number %f is %f squared", x, y)
                    );
                    System.out.println(
                        String.format("and %f squared is %f", y, yy)
                    );
                    uPSI.flag = false;
                }
            }
            catch (Exception e) {
                System.out.println(String.format("Error on thread id %d",this.tid));
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        int threads = 16;
        long v = 999999999 / threads;
        for (int tid = 0; tid < threads; tid++) {
            mtUPSI upsi = new mtUPSI(tid, v);
            upsi.start();
        }
    }
}
