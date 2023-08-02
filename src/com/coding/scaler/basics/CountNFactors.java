package com.coding.scaler.basics;

public class CountNFactors {

    public static void main(String[] args) {

        int count = 0, A = 49;
        for(int i=1; i <= Math.sqrt(A); i++ ) {
            if(A % i == 0) {
                if(A/i == i)
                    count++;
                else
                    count+=2;
            }
        }
        System.out.println(count);


        System.out.println(sumOfPositiveDivisor(6));

    }


    /**
     * You are given an integer A. You have to tell whether it is a perfect number or not.
     *
     * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
     *
     * A proper divisor of a natural number is the divisor that is strictly less than the number.
     * @param A
     * @return
     *
     * Example Input
     * Input 1:
     *
     * A = 4
     *
     * Explanation 1:
     *
     * For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
     */
    private static int sumOfPositiveDivisor(int A) {
        int sum = 0;
        for(int i=1; i < A; i++ ) {
            if(A % i == 0) {
                sum += i;
            }

            if(sum > A)
                return 0;
        }
        return sum == A ? 1: 0;
    }
}
