package com.coding.scaler.advance.arrays.sorting.radix_quick;

import java.util.*;

public class SortArrayWithKthDigit {

    public static void main(String[] args) {
        int[] A = {236, 18, 52};
        int K = 1; //ist place digit

        // Create a custom comparator based on the Kth digit
        CustomComparator customComparator = new CustomComparator(K);

        // Convert the array to a list for sorting
        List<Integer> list = new ArrayList<>();
        for (int num : A) {
            list.add(num);
        }

        // Sort the list using the custom comparator
        Collections.sort(list, customComparator);

        // Convert the sorted list back to an array
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = list.get(i);
        }

        // Print the sorted array
        System.out.println(Arrays.toString(ans));
    }

   static class CustomComparator implements Comparator<Integer> {
        int k;

        CustomComparator(int k) {
            this.k = k;
        }

        @Override
        public int compare(Integer num1, Integer num2) {
            int digit1 = (num1 / (int)Math.pow(10, k)) % 10;
            int digit2 = (num2 / (int)Math.pow(10, k)) % 10;

            if (digit1 == digit2) {
                // If Kth digits are the same, maintain stability by comparing original order
                return Integer.compare(num1, num2);
            }

            return Integer.compare(digit1, digit2);
        }
    }
}
