package com.coding.scaler.bit_manipulation;

public class Reverse32SignedBit {

    /**
     * Reverse the bits of an 32 bit unsigned integer A.
     *
     * Input 2:
     * 3
     *
     * Output 2:
     *  3221225472
     *
     *  Explanation 2:
     *
     *         00000000000000000000000000000011
     * =>      11000000000000000000000000000000
     */
    public static void main(String[] args) {
        System.out.println(reverse(3));
    }

    private static long reverse(long a) {
        int iCount = 32;
        long ans = 0;

        while (a > 0) {
            long remainder = (long) a % 2;
            iCount--;

            //last digit should convert to 2^32 then 2^31 and so on..
            ans = ans + (long) (remainder * Math.pow(2, iCount));

            a = a / 2;
        }

        return ans;
    }
}
