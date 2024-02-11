package com.coding.scaler.advance.arrays.sorting.radix_quick;

public class FindSmallestNumberByArrange {

    /**
     * Find the smallest number that can be formed by rearranging the digits given in an
     * arr = {1,3,5,6,2,3,4,1}
     *
     * op = {1, 1, 2, 3, 3, 4, 5, 6}
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1,3,5,6,2,3,4,1}));
    }

    private static String solve(int [] A) {
        int [] count = new int[10]; // Since digits are from 0 to 9

        for (int num: A) {
            count[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<10; i++) {
            while (count[i] > 0) {
                sb.append(i);
                count[i]--;
            }
        }

        return sb.toString();
    }
}
