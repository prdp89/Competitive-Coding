package com.coding.scaler.advance.maths.prime;

import java.util.Arrays;

public class PrimeSumEqualsN {

    /**
     * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
     *
     * If there is more than one solution possible, return the lexicographically smaller solution.
     *
     * NOTE: A solution will always exist. Read Goldbach's conjecture.
     *
     * Example Input
     *  100
     *
     *
     * Example Output
     *  [3, 97]
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString( primeSum(100)));
    }

    //https://www.youtube.com/watch?v=vhwIIeaGxZs
    private static int[] primeSum(int A) {
        boolean [] sieveArr = sieve(A);

        int [] res = new int[2];
        //logic is to check from Front and Back for the Prime sum equals to N.
        for (int i=2; i<= A; i++) {
            boolean first = sieveArr[i];
            boolean second = sieveArr[A - i];

            if(first && second) {
                res[0] = i;
                res[1] = A - i;
                return res;
            }
        }

        return res;
    }

    private static boolean [] sieve(int A) {
        boolean [] isPrime = new boolean[A+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false; isPrime[1] = false;

        for(int i=2; i<=A; i++) {

            if(isPrime[i]) {
                //start from next multiple of i and increment the i in each iteration
                for(int j = i*2; j<= A; j+=i) {
                    isPrime[j] = false;
                }

            }

        }
        return isPrime;
    }

}
