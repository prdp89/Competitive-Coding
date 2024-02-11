package com.coding.scaler.advance.interview_problems;

public class NumberOfDigitOne {

    /**
     * Given an integer A, find and return the total number of digit 1 appearing
     * in all non-negative integers less than or equal to A.
     *
     * Input 1:
     *
     *  A = 10
     *
     *  Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     * Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(10));
    }

    private static int solve(int A) {
        int count = 0;
        while(A >= 1) {
            String str = Integer.toString(A);
            for(Character ch : str.toCharArray()) {
                if( ch == '1')
                    count++;
            }
            count += A %10 == 1 ? 1 : 0;
            A =- 1;
        }

        return count;
    }
}
