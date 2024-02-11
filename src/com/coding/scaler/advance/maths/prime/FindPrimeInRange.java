package com.coding.scaler.advance.maths.prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimeInRange {

    /**
     * Given an integer A. Find the list of all prime numbers in the range [1, A].
     *
     * Input 1:
     * A = 7
     *
     * Output 1:
     * [2, 3, 5, 7]
     *
     * For Input 1:
     * The prime numbers from 1 to 7 are 2, 3, 5 and 7.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(7)));
    }

    //using Sieve of Erastosthenes
    //TC = O (N Log (log N))
    //SC = O (N)
    private static int[] solve(int A) {
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

        List<Integer> list = new ArrayList();
        for(int i=2; i<=A; i++) {
            if(isPrime[i]) {
                list.add(i);
            }
        }

        int [] res = new int[list.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
