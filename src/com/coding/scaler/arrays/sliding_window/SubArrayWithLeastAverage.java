package com.coding.scaler.arrays.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithLeastAverage {

    /**
     * Given an array of size N, find the subarray of size K with the least average.
     * Input 1:
     * A=[3, 7, 90, 20, 10, 50, 40]
     * B=3
     *
     * Output 1:
     * 3
     *
     * Explanation 1:
     * Subarray between indexes 3 and 5
     * The subarray {20, 10, 50} has the least average
     * among all subarrays of size 3.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(3, 7, 90, 20, 10, 50, 40)), 3));

       // System.out.println(solvePrefixSum(new int[] {3, 7, 90, 20, 10, 50, 40}, 3));
    }

    //prefix doesn;t work :(
    private static int solvePrefixSum(int [] arr, int B) {
        int [] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i=1; i<arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        int s = 0, sum = 0, ans = 0, e = arr.length - B + 1, index = 0;
        while (e < arr.length) {
            if(s == 0) {
                sum =  prefix[e];
            } else {
                sum = prefix[e] - prefix[s-1];
            }

            if(ans < sum) {
                ans = sum;
                index = s;
            }
            s++;
            e++;
        }
        return index;
    }

    private static int solve(ArrayList<Integer> list, int B) {
        int n = list.size();
        if(B > n)
            return 0;

        int sum =0;
        for (int i=0; i<B; i++)
            sum += list.get(i);

        //if(list.size() == B)
        //  return 0;

        int start = 1, end = B, min = sum, index = 0;
        while (end < n) {

            sum = sum - list.get(start-1) + list.get(end);

            if(sum < min) {
                min = sum;
                index = start;
            }

            end++;
            start++;
        }

        return index;
    }
}
