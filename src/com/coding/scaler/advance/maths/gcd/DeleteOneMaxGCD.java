package com.coding.scaler.advance.maths.gcd;

public class DeleteOneMaxGCD {

    public static void main(String[] args) {
        solve(new int[] {12, 15, 18});
    }

    /**
     * Given an integer array A of size N. You have to delete one element such
     * that the GCD(Greatest common divisor) of the remaining array is maximum.
     *
     * Find the maximum value of GCD.
     *
     * Input 1:
     *
     *  A = [12, 15, 18]
     *
     *  Output 1:
     *
     *  6
     *
     *  Explanation 1:
     *
     *  If you delete 12, gcd will be 3.
     *  If you delete 15, gcd will be 6.
     *  If you delete 18, gcd will 3.
     *  Maximum vallue of gcd is 6.
     *
     *  TC = O ( N LogMax(arr)) ; SC = O (N)
     */
    private static int solve(int[] A) {
        int n = A.length;

        int [] pf = new int[n];
        pf[0] = A[0];
        for(int i=1; i < n; i++ ) {
            pf[i] = gcd(pf[i-1], A[i]);
        }

        int [] sf = new int[n];
        sf[n-1] = A[n-1];
        for(int i=n-2; i >= 0; i-- ) {
            sf[i] = gcd(sf[i+1], A[i]);
        }

        int ans = sf[1], leftGcd = 0, rightGcd = 0; //only confusion why keep ans = sf[1] initially
        for(int i=1; i<n-1; i++) {
            leftGcd = pf[i-1];
            rightGcd = sf[i+1];
            ans  = Math.max(ans , gcd(leftGcd, rightGcd));
        }

        return ans;
    }

    private static int gcd(int a, int b) {
        if(b <= 0)
            return a;

        return gcd(b , a%b);
    }
}
