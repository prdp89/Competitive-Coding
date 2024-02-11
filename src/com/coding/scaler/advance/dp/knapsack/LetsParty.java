package com.coding.scaler.advance.dp.knapsack;

public class LetsParty {

    /**
     * In Danceland, one person can party either alone or can pair up with another person.
     *
     * Can you find in how many ways they can party if there are A people in Danceland?
     *
     * Note: Return your answer modulo 10003, as the answer can be large.
     *
     * Input 1:
     *
     *  A = 3
     *
     *  Output 1:
     *
     *  4
     *
     *
     *  Explanation 1:
     *
     *  Let suppose three people are A, B, and C. There are only 4 ways to party
     *  (A, B, C) All party alone
     *  (AB, C) A and B party together and C party alone
     *  (AC, B) A and C party together and B party alone
     *  (BC, A) B and C party together and A
     *  here 4 % 10003 = 4, so answer is 4.
     */
    public static void main(String[] args) {
        System.out.println(solve(3));
    }

    //using fibonacci pattern to solve
    private static int solve(int A) {
        if(A <= 2)
            return A;
        int mod = 10003, first = 1, second = 2, i = 2, temp = 0;

        while(i++ < A){
            temp = second + ((i-1) * first); // i-1 is equal to n-1C1 which means choosing 1 person from n-1 persons to pair up
            temp %= mod;
            first = second;
            second = temp;
        }
        return temp;
    }
}
