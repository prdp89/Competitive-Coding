package com.coding.scaler.advance.binary_search.on_answers;

public class AggressiveCowsSimple {

    public static void main(String[] args) {
        System.out.println(findMaxNumberOfCows(new int[] {1, 3,4,8,10,12, 17}, 3));
    }

    /**
     * A farmer has built a barn with N stalls.
     * A[i] -> location of ith stall
     * A[i]s are in sorted order.
     * 2) Cows are aggressive towards each other. The farmer wants
     * to maintain D distance b/w any pair of cows.
     * find the max number of cows the former can have.
     * One stall can keep 1 cow.
     *
     * Input  A = {1, 3,4,8,10,12, 17} ; D = 3
     *
     * A Farmer can keep ist cow: A[0] = 1,
     * 2nd Cow: A[2] = 4,
     * 3rd Cow: A[3] = 8,
     * 4th Cow: A[5] = 12,
     * 5th Cow: A[6] = 17
     *
     * output = 5
     *
     * Distance bw each cow is greater than equals to 3.
     */
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
