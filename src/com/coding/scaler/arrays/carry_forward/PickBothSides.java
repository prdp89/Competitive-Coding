package com.coding.scaler.arrays.carry_forward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickBothSides {

    /**
     * You are given an integer array A of size N.
     * <p>
     * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
     * <p>
     * Find and return the maximum possible sum of the elements that were removed after B operations.
     * <p>
     * NOTE: Suppose B = 4, and array A contains 10 elements, then
     * <p>
     * You can remove the first four elements or can remove the last four elements,
     * or can remove 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can remove.
     * <p>
     * Input 1:
     * <p>
     * A = [5, -2, 3 , 1, 2]
     * B = 3
     * <p>
     * Output 1:
     * <p>
     * 8
     * <p>
     * Explanation 1:
     * <p>
     * Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, -2, 3, 1, 2));

        System.out.println(solve(list, 3));
    }

    private static int solve(List<Integer> list, int b) {

        /**
         * For B = 3 we have these possible choices:
         *
         * L    R
         * 3    0  pick 3 elements from start and null from end
         * 2    1  pick 2 elements from start and 1 from end
         * 1    2
         * 0    3
         */
        int n = list.size();
        int curr = 0, ans = (int) -1e9;

        for (int i = 0; i < b; i++) {
            curr += list.get(i);
        }

        int back = b - 1; //if b= 3 initially then index to 2
        ans = Math.max(ans, curr);

        //J loops from N-1 ... N - b bcz we already traversed first b elements.
        for (int j = n - 1; j >= n - b; j--) {
            //so adding 1 element from end
            curr += list.get(j);

            //and minus 1 element from begin
            curr-= list.get(back);

            //subtracting back to exhaust possible options.
            back--;

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}
