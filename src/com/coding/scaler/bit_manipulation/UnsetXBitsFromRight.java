package com.coding.scaler.bit_manipulation;

public class UnsetXBitsFromRight {

    /**
     * Given an integer A. Unset B bits from the right of A in binary.
     *
     * For example, if A = 93 and B = 4, the binary representation of A is 1011101.
     * If we unset the rightmost 4 bits, we get the binary number 1010000, which is equal to the decimal value 80.
     *
     * Input 1:-
     * A = 25
     * B = 3
     *
     * Output 1:-
     * 24
     *
     * Explanation 1:-
     * A = 11001 to 11000
     */
    public static void main(String[] args) {
        System.out.println(solve(25, 3));
    }

    private static long solve(long A, int B) {
        int i=0;
        while(B-- > 0) {

            if((A &  (1 << i))!= 0) {
                A = A ^ (1 << i);
            }

            i++;
        }
        return A;
    }

}
