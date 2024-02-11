package com.coding.scaler.advance.maths;

import java.util.Arrays;

public class APowerBFactModM {

    public static void main(String[] args) {
        System.out.println(solve(2,2));
    }

    /**
     * Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
     *
     * "^" means power,
     * "%" means mod, and
     * "!" means factorial.
     *
     * Note: Ensure to handle integer overflow when performing the calculations.
     *
     * Input 1:
     *
     * A = 1
     * B = 1
     *
     * Output 1:
     * 1
     *
     * Explanation 1:
     *
     *  1! = 1. Hence 1^1 = 1.
     *
     *
     *
     * Reason of doing : (mod-1) :
     * In power function, as Fermet’s theorem states (A^(p-1))%p = 1 where p is prime number,
     * here p=1e9+7, so we are raising the power of A to p-1 which is 1e9+6.
     *
     * And in factorial function, B! can turn out to be greater than p and let’s say B! = p+1.
     * and when finding power we need to calculate A^(B!) = A^(p+1)
     * but we know A^(p-1) = 1, so we can rewrite our required equation A^(p+1) to A^(p-1) * A^(2)
     * and if you observe 2 is the remainder of B! % (p-1). So for this, I have used p-1 in factorial function.
     */
    private static int solve(int A, int B) {
        long mod=1000000007;

        long fact=1;
        for( long i=2; i<=B;i++){
            fact=(fact*i)%(mod-1);
        }
        int ans= (int)pow(A,fact,mod);
        return ans;
    }

    private static long pow(long a, long b, long c) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        if(a == 0)
            return 0;

        if(b == 0)
            return 1;

        long ha = pow(a, b/2, c);
        long hp = ((ha % c) * (ha % c)) % c;

        if(b % 2 == 1) {
            long x = (((hp % c) * (a % c)) % c);
            if(x < 0){
                x+=c;
            }
            return x;
        } else {
            return hp;
        }
    }
}
