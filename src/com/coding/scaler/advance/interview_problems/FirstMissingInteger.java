package com.coding.scaler.advance.interview_problems;

public class FirstMissingInteger {

    /**
     * Given an unsorted integer array, A of size N. Find the first missing positive integer.
     *
     * Note: Your algorithm should run in O(n) time and use constant space.
     */
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1, 2, 0}));
    }

    //https://leetcode.com/problems/first-missing-positive/
    private static int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i=0; i<n; i++) {

            //A[i] != A[A[i] - 1] : check for correct element sitting in Index position
            //eg: { 3 , 2 , 1, 0}
            //Scenario-1: 3 is not sitting in its correct position, so: 3 != A[3-1] => 3 != 2 so swap it :)
            //Scenario-2: 2 is sitting in correct position
            //Scenario-3: 1 is not sitting in its correct position, so: 1 != A[1-1] => 1 != 3 so swap it :)

            //Therefore: A[A[i] - 1] : showing the correct position of element A[i]
            while (A[i] != i+1 && A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1] ) {
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1]= temp;
            }
        }

        int res = A.length + 1;
        for (int i=0; i<n; i++) {
            if(i+1 != A[i]){
                res = i+1;
                break;
            }
        }

        return res;
    }
}
