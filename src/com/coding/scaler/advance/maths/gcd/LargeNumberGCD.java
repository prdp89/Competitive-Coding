package com.coding.scaler.advance.maths.gcd;

public class LargeNumberGCD {

    /**
     * You are given a number A and a number B. Greatest Common Divisor (GCD)
     * of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
     * As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.
     *
     * You have to return the value of GCD found.
     *
     * The greatest common divisor of 2 numbers, A and B, is the largest number, D that divides both A and B perfectly.
     *
     * Problem Constraints
     * 1 <= A <= B <= 10100
     *
     * A = "1"
     * B = "3"
     *
     * Example Output
     * 1
     *
     * Greatest divisor that divides both 1 and 3 is 1.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve("1", "3"));
    }

    private static String solve(String A, String B) {
        //property  gcd(x,x+1) = 1
        if(A.equals(B))
            return A;

        return "1";
    }
}
