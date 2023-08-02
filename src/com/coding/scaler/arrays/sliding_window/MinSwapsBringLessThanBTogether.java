package com.coding.scaler.arrays.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSwapsBringLessThanBTogether {

    /**
     * Given an array of integers A and an integer B, find and return the minimum number of
     * swaps required to bring all the numbers less than or equal to B together.
     * <p>
     * Note: It is possible to swap any two elements, not necessarily consecutive.
     * <p>
     * Input 1:
     * <p>
     * A = [1, 12, 10, 3, 14, 10, 5]
     * B = 8
     * <p>
     * Output 1:
     * <p>
     * 2
     * <p>
     * Explanation 1:
     * <p>
     * A = [1, 12, 10, 3, 14, 10, 5]
     * After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
     * After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
     * Now, all elements less than or equal to 8 are together.
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 12, 10, 3, 14, 10, 5));
        //System.out.println(solveBruteForce(list, 8));

        System.out.println(solveOptimal(list, 8));
    }

    private static int solveBruteForce(List<Integer> list, int B) {
        //good elements <= B
        //bad elements > B

        int goodElements = 0, bad_elements = 0, n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= B)
                goodElements++;
        }

        for (int i = 0; i < goodElements; i++) {
            if (list.get(i) > B)
                bad_elements++;
        }

        if (goodElements == 0 || goodElements == n || goodElements == 1)
            return 0;

        int start = 0, end = goodElements - 1; //good_elements - 1 are initial window size.
        int ans = bad_elements, count; //initially we have to swap for worst case all bad elements to bring good elements together.

        //A = [1, 12, 10, 3, 14, 10, 5]
        //g_e= 3 ; b_e= 4
        while (end < n && start < n) {

            count = 0;
            //Now for each window of size good_elements, we are finding no. of bad elements inside such that,
            //we can swap those min. number of bad elements to create a good_elements subarray.
            for (int i = start; i <= end; i++) {
                if (list.get(i) > B)
                    count++;
            }

            if (count < ans)
                ans = count;

            start++;
            end++;
        }

        return ans;
    }

    private static int solveOptimal(List<Integer> list, int B) {
        //good elements <= B
        //bad elements > B

        int goodElements = 0, bad_elements = 0, n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= B)
                goodElements++;
        }

        for (int i = 0; i < goodElements; i++) {
            if (list.get(i) > B)
                bad_elements++;
        }

        if (goodElements == 0 || goodElements == n || goodElements == 1)
            return 0;

        int start = 1, end = goodElements; //good_elements are initial window size.
        int ans = bad_elements, count = bad_elements; //initially we have to swap for worst case all bad elements to bring good elements together.

        //A = [1, 12, 10, 3, 14, 10, 5]
        //g_e= 3 ; b_e= 4
        while (end < n) {

            //SW cheat code says:
            //sum = sum - a[s-1] + a[e] //we have to exclude first to include the next

            //so, excluding the start-1 to find max. bad_ele in next window
            if (list.get(start - 1) > B)
                count--; //excluding the start-1

            //this will pick the next element since it's greater than B
            if (list.get(end) > B)
                count++;

           /* if (count < ans)
                ans = count;*/

            ans = Math.min(count, ans);

            start++;
            end++;
        }

        return ans;
    }
}
