package com.coding.scaler.advance.binary_search.on_answers;

import java.util.Arrays;

public class BackPackWithBBags {

    /**
     * you have N items to carry with you and each item has weight A[I].
     *
     * you have B backpacks and you want to carry maximum weight of W in
     * your backpack and you want to make sure you carry all the items without
     * exceeding the weight limit. your task to determine minimum possible wight
     * capacity of your backpack required to ensure that you carry all the items without having
     * to leave anything behind.
     *
     * Input: A = {1, 2, 3}, B =3
     * Output: 3
     *
     *
     * Input: A = {3,2,2,1}, B =4
     *      * Output: 3
     */

    public static void main(String[] args) {
        int [] A = {1, 2, 3};
        int B = 3;
        System.out.println(findMinimumCapacity(A, B));
    }

    public static int findMinimumCapacity(int[] A, int B) {
        int left = Arrays.stream(A).max().getAsInt(); // Minimum possible capacity
        int right = Arrays.stream(A).sum(); // Maximum possible capacity
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCarryAll(A, B, mid)) {
                ans = mid;
                // If we can carry all items with capacity 'mid', try a smaller capacity
                right = mid-1;
            } else {
                // If we cannot carry all items with capacity 'mid', try a larger capacity
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean canCarryAll(int[] A, int B, int capacity) {
        int backpacksUsed = 0;
        int currentCapacity = 0;

        for (int weight : A) {
            if (weight > capacity) {
                return false; // Individual item weight exceeds the capacity
            }

            if (currentCapacity + weight > capacity) {
                backpacksUsed++;
                currentCapacity = 0;
            }

            currentCapacity += weight;
        }

        return backpacksUsed < B;
    }
}
