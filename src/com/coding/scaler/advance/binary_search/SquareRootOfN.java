package com.coding.scaler.advance.binary_search;

public class SquareRootOfN {

    public static void main(String[] args) {
        System.out.println(sqrt(11));
    }

    private static int sqrt(int A) {
        long ans = 0;
        long l=1, r = A;

        while (l <= r) {
            long mid = (l+r) / 2 ;
            if(mid*mid <= A) {
                l = mid+1;
                ans = mid;
            }
            else
                r = mid-1;
        }

        return (int) ans;
    }
}
