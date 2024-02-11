package com.coding.scaler.advance.maths.prime;

import java.util.Arrays;

public class SmallestPrimeFactorOfN {

    /**
     * Given N, find smallest prime factors for all numbers 2 to N.
     *
     * E.g: Input = 10
     *
     * All number 2 ..10 are:
     *
     * Numbers:                 2 3 4 5 6 7 8 9 10
     * Smallest prime factors:  2 3 2 5 2 7 2 3 2
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SPF(10)));
    }

    //using same Sieve of Eratheneses
    //same complexity as FindPrimeInRange
    private static int [] SPF(int n) {
        int [] spf = new int[n+1];

        //initialize with i for each number, consider that each number has smallest prime factor i.
        for(int i=0; i<=n; i++) {
            spf[i] = i ;
        }

        spf[0] = spf[1] = 0;

        for (int i=2; i<=n; i++) {

            //if number is itself the smallest prime factor, mark all next multiples of that i'th num.
            if(i == spf[i]) {
                for(int j=i*2; j <= n; j+=i) {

                    //let's say we are iterating for i = 5, so spf[i] = 5 initially
                    //next we move to 5*2 = 10 multiple and check if spf[10] which is 2 less than 5.
                    //so we spf[10] should be set as 2 only.
                    spf[j] = Math.min(i, spf[j]);
                }
            }
        }

        return spf;
    }
}
