package com.coding.scaler.recursion;

public class APowerBModC {

    public static void main(String[] args) {
        System.out.println(pow(2, 3, 3));
    }

    /**
     * Explanation 1:
     * 2^3 % 3 = 8 % 3 = 2
     */
    private static int pow(int a, int b, int c) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        if(a == 0)
            return 0;

        if(b == 0)
            return 1;

        long ha = pow(a, b/2, c);
        long hp = ((ha % c) * (ha % c)) % c;

        if(b % 2 == 1) {
            int x = (int) (((hp % c) * (a % c)) % c);
            if(x < 0){
                x+=c;
            }
            return x;
        } else {
            return (int) hp;
        }
    }
}
