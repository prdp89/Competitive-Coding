package com.coding.scaler.advance.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SumMinMaxSlidingWindowB {

    /**
     * Given an array A of both positive and negative integers.
     *
     * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
     *
     * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
     *
     * Input 1:
     *
     *  A = [2, 5, -1, 7, -3, -1, -2]
     *  B = 4
     *
     *  Output 1:
     *
     *  18
     *
     *  Explanation 1:
     *
     *  Subarrays of size 4 are :
     *     [2, 5, -1, 7],   min + max = -1 + 7 = 6
     *     [5, -1, 7, -3],  min + max = -3 + 7 = 4
     *     [-1, 7, -3, -1], min + max = -3 + 7 = 4
     *     [7, -3, -1, -2], min + max = -3 + 7 = 4
     *     Sum of all min & max = 6 + 4 + 4 + 4 = 18
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {2, 5, -1, 7, -3, -1, -2}, 4));
    }

    private static int solve(int[] A, int B) {
        long sum=slidingMaxMinSum(A,B);
        return (int)(((sum)%1000000007)+1000000007)%1000000007;
    }

    private static long slidingMaxMinSum(final int[] A, int B) {
        Deque<Integer> dqueMax= new LinkedList();
        Deque<Integer> dqueMin= new LinkedList();

        int n=A.length;
        long ans=0;

        for(int i=0;i<B;i++){
            while(!dqueMax.isEmpty() && A[dqueMax.peekLast()] < A[i]){
                dqueMax.pollLast();
            }
            dqueMax.offerLast(i);
            while(!dqueMin.isEmpty() && A[dqueMin.peekLast()] > A[i]){
                dqueMin.pollLast();
            }
            dqueMin.offerLast(i);
        }
        ans=A[dqueMax.peekFirst()]+A[dqueMin.peekFirst()];

        int l=1;
        int r=B;

        while(r<n){
            while(!dqueMax.isEmpty() && A[r]>=A[dqueMax.peekLast()]){
                dqueMax.pollLast();
            }
            dqueMax.offerLast(r);
            if(l-1==dqueMax.peekFirst()){ //slide the window
                dqueMax.pollFirst();
            }

            while(!dqueMin.isEmpty() && A[r]<=A[dqueMin.peekLast()]){
                dqueMin.pollLast();
            }
            dqueMin.offerLast(r);
            if(l-1==dqueMin.peekFirst()){ //slide the window
                dqueMin.pollFirst();
            }

            ans=(ans+A[dqueMax.peekFirst()]+A[dqueMin.peekFirst()]);

            l++;
            r++;

        }
        return ans;
    }
}
