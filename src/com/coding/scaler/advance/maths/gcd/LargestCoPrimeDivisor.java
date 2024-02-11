package com.coding.scaler.advance.maths.gcd;

public class LargestCoPrimeDivisor {

    /**
     * You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
     *
     * X divides A i.e. A % X = 0
     * X and B are co-prime i.e. gcd(X, B) = 1
     *
     * Input 1:
     *
     *  A = 30
     *  B = 12
     *
     *  Output 1:
     *
     *  5
     *
     *  Explanation 1:
     *
     *  All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30).
     *  The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(cpFactBF(30, 12));

        System.out.println(cpFactOptimal(30,12));
    }

    private static int cpFactOptimal(int A, int B) {
        //First, we know answer lies in the range of 1..A that means A % X is always true, so we find GCD(A, B).

        //Next, we need to prove GCD(X, B) == 1 that means X and B has no other factor other than 1. So, finally we have
        //to keep dividing A with it's GCD until we get GCD(X, B) == 1.

        while (gcd(A, B) != 1) {
            A /= gcd(A, B);
        }

        return A;
    }

    private static int cpFactBF(int A, int B) {
        int ans = 0;
        for (int i=1; i<=A; i++) {
            if(A%i == 0 && gcd(i, B) == 1) {
                ans = i;
            }
        }
        return ans;
    }

    private static int gcd(int a, int b) {
        if(b <= 0)
            return a;

        return gcd(b , a%b);
    }
}
