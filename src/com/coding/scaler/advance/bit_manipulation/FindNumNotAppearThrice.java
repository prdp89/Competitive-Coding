package com.coding.scaler.advance.bit_manipulation;

public class FindNumNotAppearThrice {

    /**
     * Given an array of integers, every element appears thrice except for one, which occurs once.
     *
     * Find that element that does not appear thrice.
     *
     * NOTE: Your algorithm should have a linear runtime complexity.
     *
     * Could you implement it without using extra memory?
     *
     * Input 1:
     *
     *  A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
     *
     *  Output 1:
     *
     *  4
     *
     *  Explanation 1:
     *
     *  4 occurs exactly once in Input 1.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 1, 2, 4, 3, 3, 2, 2, 3, 1, 1 }));
    }

    private static int singleNumber(final int[] A) {
        int res = 0;

        //Integer range is 2 ^ 32, so checking every bit 0..31
        for(int i=0; i<32; i++) {
            int sum =0;

            //checking if ith bit is set, calculating its sum
            for(int j=0; j < A.length; j++) {
                if((A[j] & (1 << i)) != 0) //comparing ==  1 doesn't work here..
                    sum += 1;
            }

            //if sum of bit doesn't MOD 3 that means that bit can contribute to result (that bit not appearing thrice).
            //so, converting that bit to decimal and adding to the result.
            if(sum % 3 != 0)
                res = (int)(res + Math.pow(2, i));
        }

        return res;
    }
}
