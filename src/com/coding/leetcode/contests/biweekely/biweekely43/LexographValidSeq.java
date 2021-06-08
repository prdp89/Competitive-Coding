package com.coding.leetcode.contests.biweekely.biweekely43;

import java.util.Arrays;
import java.util.TreeSet;

public class LexographValidSeq {

    //https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
    private static int[] ans;

    //https://leetcode.com/contest/biweekly-contest-43/problems/construct-the-lexicographically-largest-valid-sequence/
    public static void main( String[] args ) {
        int n = 3;
        System.out.println(Arrays.toString(constructDistancedSequence(n)));
    }

    //Runtime: 6 ms, faster than 14.26% of Java 
    private static int[] constructDistancedSequence( int n ) {
        TreeSet<Integer> st = new TreeSet<>();    //  using treeset to iterate optional in sorted(decreasing order)
        for (int i = 1; i <= n; i++) {
            st.add(-i);    //  adding options(values to add) with -ve sign to achieve decreasing ordered TreeSet
        }

        solve(new int[(2 * n) - 1], 0, st);
        return ans;
    }

    private static void solve( int[] arr, int idx, TreeSet<Integer> st ) {
        if (idx == arr.length || ans != null) {    //  base case
            if (ans != null) {    //  ans != null(in case we already have an answer)
                return;
            }
            ans = new int[arr.length];    //  we have an answer, just deep copy arr to this.ans and return it as solution
            for (int i = 0, sz = arr.length; i < sz; i++) {
                ans[i] = arr[i];
                arr[i] = 0;
            }
            return;
        }

        if (arr[idx] != 0) {    //  if our current position is occupied, we will do work for next position
            solve(arr, idx + 1, st);
            return;
        }
        //  iterate our current options(used a deep copy of set to prevent reshashing while iteration)
        //  later in loop we will delete values while placing them in array as they are no longer needed
        for (int num : new TreeSet<>(st)) {
            num = -num;    //  converting to +ve again
            if (num == 1) {    //  if num == 1 then only 1 occurence is desired
                arr[idx] = 1;
                st.remove(-1);
                solve(arr, idx + 1, st);
                st.add(-1);
                arr[idx] = 0;
                return;
            } else {
                if (idx + num >= arr.length || arr[idx + num] != 0) {    //  if idx + num > size or arr[idx + num] != 0 then our num is not suitable
                    continue;
                }

                arr[idx] = arr[idx + num] = num;    //  incase suitable then place
                st.remove(-num);    //  remove what is used
                solve(arr, idx + 1, st);    //  using power of recursion XD
                st.add(-num);    //  incase of backtrack, add removed option again
                arr[idx] = arr[idx + num] = 0;    //  backtrack

                if (ans != null) {    //  if ans != null we already have an answer, return
                    return;
                }
            }
        }
    }
}
