package com.coding.scaler.advance.maths.prime;

import java.util.Arrays;

public class CountOfDivisors {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {2, 3, 4, 5})));
    }

    /**
     * Given an array of integers A, find and return the count of divisors of each element of the array.
     *
     * NOTE: The order of the resultant array should be the same as the input array.
     *
     * Input 1:
     *
     *  A = [2, 3, 4, 5]
     *
     *  Output 1:
     *
     *  [2, 2, 3, 2]
     *
     *  Explanation 1:
     *
     *  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
     *  So the count will be [2, 2, 3, 2].
     */

    private static int[] solve(int[] A) {
        int n = A.length, max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            max = Math.max(max, A[i]);
        }

        int [] spf = SPF(max);
        int [] res = new int[A.length];
        for(int i=0; i<n; i++) {
            int item = A[i], total = 1;
            while(item != 1) {
                int p = spf[item], count = 0;
                while(item % p == 0) {
                    count = count+1;
                    item = item / p;
                }
                total *= count + 1;
            }
            res[i] = total;
        }
        return res;
    }

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
