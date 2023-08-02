package com.coding.scaler.basics;

public class SqrtOfNum {

    //Time: O(1)
    //the exponential of the logarithm of the integer divided by two.
    public static void main(String[] args) {
        int x = 25;

        double logX = Math.log(x);
        double result = Math.exp( logX / 2);

        // floor function to get integer part of the result
        int floorResult = (int)Math.floor(result);

        // If the integer square of the floor result is
        // equal to the input x, then x is a perfect square,
        // and floor result is the square root.
       /* if (floorResult * floorResult == x) {
            return floorResult;
        }
        else { // If not, then x is not a perfect square,
            // and floor result is the floor of the
            // square root.
            return floorResult;
        }*/

        System.out.println(floorResult);
    }

    //Time: O(Log N)
    public static int floorSqrt(int x)
    {
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x / 2, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            // If x is a perfect square
            if (mid * mid == x)
                return (int)mid;

            // Since we need floor, we update answer when
            // mid*mid is smaller than x, and move closer to
            // sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            }
            else // If mid*mid is greater than x
                end = mid - 1;
        }
        return (int)ans;
    }

    //Time: O(sqrt(N))
    public int solve(int A) {
        int res = -1;

        for(int i=1; i * i<= A; i++) {
            if(i*i == A)
                return i;
        }
        return res;
    }
}
