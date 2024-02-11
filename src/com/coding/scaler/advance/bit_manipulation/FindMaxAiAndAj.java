package com.coding.scaler.advance.bit_manipulation;

public class FindMaxAiAndAj {

    public static void main(String[] args) {
        System.out.println(solve(new int[] {53, 39, 88}));
    }

    /**
     * Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
     *
     * Input 1:-
     * A = [53, 39, 88]
     *
     * Output 1:-
     * 37
     *
     * Explanation 1:-
     * 53 & 39 = 37
     * 39 & 88 = 0
     * 53 & 88 = 16
     * Maximum among all these pairs is 37
     *
     */
    private static int solve(int[] A) {
        int ans = 0;

        //looping reverse bcz last bit {1 0 0} 1 will provide the max value when we perform AND operation.
        for(int i=31; i>=0; i--) {
            int sum = 0;

            //summing the set bit, rest of A[j] set to zero bcz that will decrease the AND operation result.
            for(int j=0; j<A.length; j++)
                if((A[j] & (1 << i)) != 0)
                    sum++;

            //Disqualification logic only valid when we have at-least two set bits.
            //else,  1 & 0 == 0 that doesn't make sense to remove a single element bcz this item can
            //contribute further in next bit position.
            if(sum >= 2) {
                ans = ans + (int)Math.pow(2, i);

                //looping and disqualify if ith is Zero.
                for(int j=0; j<A.length; j++) {
                    if((A[j] & (1 << i)) == 0)
                        A[j] = 0;
                }
            }
        }

        return ans;
    }
}
