package com.coding.scaler.advance.arrays;

import java.util.Arrays;

public class AddOneToNumber {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {3, 7, 6, 4, 0, 5, 5, 5 })));
    }

    private static int[] plusOne(int[] A) {
        int n = A.length;

        int i = n-1;
        // Iterate over the array from right to left
        for (; i >= 0 && A[i] == 9; i--) {
            // If the digit is 9, set it to 0
            A[i] = 0;
        }

        if(i < 0) {
            // If all digits were 9, create a new array with one additional element
            int[] newNumber = new int[n + 1];

            // Set the most significant digit to 1, as we are incrementing the number by 1
            newNumber[0] = 1;
            newNumber[n-1] = 0;

            return newNumber;
        }

        A[i] += 1;

        return A;

    }
}
