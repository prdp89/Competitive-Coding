package com.coding.scaler.recursion;

public class IsSumOfDigitOne {

    /**
     * Given a number A, check if it is a magic number or not.
     *
     * A number is said to be a magic number if the sum of its digits
     * is calculated till a single digit recursively by adding the sum of
     * the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.
     *
     * A = 83557
     * Sum of digits of (83557) = 28
     *  Sum of digits of (28) = 10
     *  Sum of digits of (10) = 1.
     *  Single digit is 1, so it's a magic number. Return 1.
     */

    public int solve(int A) {

        if(A<10){
            if( A == 1)
                return 1;
            else return 0;
        }


        return solve(print(A));
    }

    private int print(int a) {
        if(a == 0)
            return 0;

        return a % 10 + print(a / 10);
    }
}
