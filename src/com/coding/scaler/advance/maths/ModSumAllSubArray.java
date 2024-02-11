package com.coding.scaler.advance.maths;

public class ModSumAllSubArray {

    /**
     * Given an array of integers A, calculate the sum of A [ i ] % A [ j ]
     * for all possible i, j pairs. Return sum % (109 + 7) as an output.
     *
     * Problem Constraints
     * 1 <= length of the array A <= 10^5
     *
     * 1 <= A[i] <= 10^3
     *
     * Input 1:
     *
     *  A = [1, 2, 3]
     *
     *  Output 1:
     *
     *  5
     *
     *  Explanation 1:
     *
     *  (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solveBF(new int[] {1, 2, 3}));

        System.out.println(solveOptimal(new int[] {1,2,3}));
    }

    //using count array we are using 10^3 property.
    private static int solveOptimal(int[] A) {
        int mod = (int)1e9 + 7;
        int sum = 0;

        int [] count = new int [1001];
        for(int item: A) {
            count[item]++;
        }

        //2 nested to make 2 pairs and generate MOD sum.
        for(int i=1; i < count.length; i++) {
            for(int j=1; j < count.length; j++) {
                sum += ( (i % j) * count[i] * count[j] ) % mod;
                sum %= mod;
            }
        }

        return sum;
    }

    //passing 50/100 test cases bcz array length go till 10^5
    private static int solveBF(int[] A) {
        long mod = (long)1e9 + 7;
        int sum = 0;

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A.length; j++) {
                sum = (int)((sum + (A[i] % A[j]) % mod) % mod);
            }
        }

        return sum;
    }
}
