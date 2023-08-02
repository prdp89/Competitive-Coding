package com.coding.scaler.bit_manipulation;

public class ArraySplitOrMerge {

    /**
     * You have an array A with N elements. We have two types of operation available on this array :
     * We can split an element B into two elements, C and D, such that B = C + D.
     * We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
     *
     * You have to determine whether it is possible to convert array A to size 1, containing a single
     * element equal to 0 after several splits and/or merge?
     *
     * Input 1:
     *  A = [9, 17]
     *
     *  Output 1:
     *  Yes
     *
     *  Explanation 1:
     *
     *  Following is one possible sequence of operations -
     *  1) Merge i.e 9 XOR 17 = 24
     *  2) Split 24 into two parts each of size 12
     *  3) Merge i.e 12 XOR 12 = 0
     *  As there is only 1 element i.e 0. So it is possible.
     */
    public static void main(String[] args) {

    }

    public String solve(int[] A) {
        int xor = 0;
        for(int item : A) {
            xor = xor ^ item;
        }

        return ( xor & 1 ) == 0 ? "Yes" : "No";
    }
}
