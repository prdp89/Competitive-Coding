package com.coding.scaler.basics;

public class ModArray {

    /**
     * You are given a large number in the form of a array A of size N where each element denotes a digit of the number.
     * You are also given a number B. You have to find out the value of A % B and return it.
     * @param args
     *
     * A = [1, 4, 3]
     * B = 2
     *
     * Output 1:
     * 1
     *
     * 143 is an odd number so 143 % 2 = 1.
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1, 4, 3}, 2));
    }

    private static int solve(int[] A, int B) {
        long sum = 0, x = 1;

        for(int i=A.length-1; i >= 0; i--) {
            sum = (sum + A[i] * x) % B;
            x = (x * 10) % B;
        }

        return (int)sum;
    }
}
