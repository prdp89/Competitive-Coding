package com.coding.leetcode.bs.monotonic;

public class ShipPackageDDays {

    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    public static void main( String[] args ) {
        int[] weigh = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println(shipWithinDays(weigh, D));
    }

    //We have given the weights of Package and we have to transfer the packages in same order but:
    //1. Max partition within D days
    //2. The Sum of each partition is Min as possible.
    //3. We have to return the least capacity of ship (max sum of weights among all..)

    //Runtime: 8 ms, faster than 95.30% of Java
    private static int shipWithinDays( int[] weights, int D ) {
        // Lets first define our feasible range
        int lo = weights[0];

        for (int w : weights)
            lo = Math.max(lo, w); // we would at least need the capacity such that the largest weight can be shipped, so that would be lower bound

        int hi = 0;
        for (int w : weights)
            hi += w; // we would not need the capacity more than sum of all weights, so that would be upper bound

        int ans = hi; // since we need to minimize the capacity, start with hi, later we will update/minimize it
        while (lo <= hi) { // No need to think here :D
            int mid = lo + (hi - lo) / 2;

            if (isPossible(weights, mid, D)) {
                ans = mid; // Update answer
                hi = mid - 1; // Try smaller capacities
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    // Code to check whether it is possible to ship with this capacity
    private static boolean isPossible( int[] weights, int capacity, int D ) {
        int cur = 0;
        for (int w : weights) {

            if (cur + w <= capacity) {
                cur += w;
            } else {
                //we consumed on day by creating a group of weights
                D--;

                if (D == 0)
                    return false;

                cur = w;//assigning last weigh to new group.
            }
        }

        return true;
    }
}
