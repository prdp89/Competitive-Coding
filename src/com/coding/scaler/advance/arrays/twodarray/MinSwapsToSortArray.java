package com.coding.scaler.advance.arrays.twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinSwapsToSortArray {

    /**
     * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
     *
     * It is allowed to swap any two elements (not necessarily consecutive).
     *
     * Find the minimum number of swaps required to sort the array in ascending order.
     *
     * Input 1:
     *
     * A = [1, 2, 3, 4, 0]
     *
     * Output 1:
     *
     * 4
     *
     * There are many ways, to make the array sorted,
     *
     * One of the sequence of swaps as follow:
     *     Initial array   ->   [1, 2, 3, 4, 0]
     *  swapping (1, 2) becomes [2, 1, 3, 4, 0]
     *  swapping (2, 3) becomes [3, 1, 2, 4, 0]
     *  swapping (4, 0) becomes [3, 1, 2, 0, 4]
     *  swapping (3, 0) becomes [0, 1, 2, 3, 4].
     * Thus the array is sorted in 4 swaps.  It cannot be sorted inlesser than 4 swaps.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solveTLE(new int[] {1, 2, 3, 4, 0}));

        System.out.println(solveOptimal(new int[] {1, 2, 3, 4, 0}));

        System.out.println(solveSwapByIndexPosition(new int[] {1, 2, 3, 4, 0}));
    }

    //This Algo works on Array of N distinct elements irrespective of 0..N permutation of elements.
    private static int solveOptimal(int[] arr) {
        List<Pair> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            list.add(new Pair(arr[i], i));
        }

        list.sort((a, b) -> a.num - b.num);

        //This algo is to compare List with Arr and make list == arr to calculate min swaps.
        //Means sorted list swap equals to unsorted arr to calculate the min swaps.

        int swaps = 0;

        for (int i=0; i<arr.length; i++) {
            Pair p = list.get(i);

            int value = p.num;
            int index = p.index;

            if(i != index) {
                swaps++;

                //swap list of indexes: (i, index)
                Collections.swap(list, list.get(i).index, list.get(index).index);

                //decrement such that i'th place element should set before moving to next
                i--;
            }
        }

        return swaps;
    }

    //This works bcz elements are 0..N permuations.
    private static int solveSwapByIndexPosition(int[] A) {
        int count = 0;
        int i=0;
        while(i<A.length) {
            while(A[i]!= i){
                int t = A[A[i]];
                A[A[i]]=A[i];
                A[i]=t;
                count++;
            }
            i++;
        }
        return count;
    }

    public static class Pair {
        public int getNum() {
            return num;
        }

        public int getIndex() {
            return index;
        }

        int num;
        int index;

        Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    //passed 170/200 test cases.
    private static int solveTLE(int[] arr) {
        int N = arr.length, ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);
        for (int i = 0; i < N; i++) {

            // This is checking whether
            // the current element is
            // at the right place or not
            if (arr[i] != temp[i]) {
                ans++;

                // Swap the current element
                // with the right index
                // so that arr[0] to arr[i] is sorted
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }
        return ans;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int indexOf(int[] arr, int ele)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }
}
