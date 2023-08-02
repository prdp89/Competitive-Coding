package com.coding.scaler.arrays.interview_problems;

public class ByoreMooreExtendedNby3 {

    /**
     * You're given a read-only array of N integers. Find out if any integer occurs more than N/3
     * times in the array in linear time and constant additional space.
     * If so, return the integer. If not, return -1.
     * <p>
     * If there are multiple solutions, return any one.
     * <p>
     * Input 1:
     * [1 2 3 1 1]
     * <p>
     * Output 1:
     * 1
     * <p>
     * Observation: How many integers can occur more than floor(N/3) times in the given array:
     * <p>
     * If we closely observe, in the given array, there can be a maximum of two integers that can
     * occur more than floor(N/3) times. Let’s understand it using the following scenario:
     * <p>
     * Assume there are 8 elements in the given array. Now, if there is any majority element,
     * it should occur more than floor(8/3) = 2 times. So, the majority of elements should occur
     * at least 3 times. Now, if we imagine there are 3 majority elements, then the total occurrence
     * of them will be 3X3 = 9 i.e. greater than the size of the array. But this should not happen.
     * <p>
     * That is why there can be a maximum of 2 majority elements when calculated for N/3 times.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1};
        System.out.println(repeatedNumber(arr));
    }

    private static int repeatedNumber(int[] A) {
        int count_1 = 0, count_2 = 0, num_1 = 0, num_2 = 0, n = A.length;

        //finding two majority element
        for (int item : A) {
            if (count_1 == 0 && num_2 != item) {
                count_1 = 1;
                num_1 = item;
            } else if (count_2 == 0 && num_1 != item) {
                count_2 = 1;
                num_2 = item;
            } else if (item == num_1) count_1++;
            else if (item == num_2) count_2++;
            else {
                count_1--;
                count_2--;
            }
        }

        count_1 = 0; count_2=0;
        for (int item : A) {
            if (item == num_1) {
                count_1++;
            }

            if (item == num_2) {
                count_2++;
            }
        }

        if(count_1 > n /3)
            return num_1;
        if(count_2 > n /3)
            return num_2;

        return -1;
    }
}
