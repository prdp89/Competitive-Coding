package com.coding.scaler.advance.binary_search.on_answers;

import java.util.Arrays;

public class AggressiveCowsReal {

    /**
     * Farmer John has built a new long barn with N stalls.
     * Given an array of integers A of size N where each element of the array represents the
     * location of the stall and an integer B which represents the number of cows.
     *
     * His cows don't like this barn layout and become aggressive towards each other once put into a stall.
     * To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that
     * the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
     *
     * Input 1:
     *
     * A = [1, 2, 3, 4, 5]
     * B = 3
     *
     * Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1, 2, 3, 4, 5}, 3));
    }

    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int l = 1, n = A.length, r = A[n-1], ans = 1;

        while (l <= r) {
            int mid = l + (r-l) / 2; //min distance between 2 cows
            int cowsCountWithMidDistance = findMaxNumberOfCows(A, mid);

            //bcz we need to maximize the min distance
            if(cowsCountWithMidDistance >= B) {
                ans = mid;
                l = mid+1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private static int findMaxNumberOfCows(int [] A, int D) {
        int count = 1, lastCowPos = A[0];
        for (int i=1; i<A.length; i++) {
            if(A[i] - lastCowPos >= D) {
                count++;
                lastCowPos = A[i];
            }
        }

        return count;
    }
}
