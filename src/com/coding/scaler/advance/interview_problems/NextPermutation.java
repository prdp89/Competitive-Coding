package com.coding.scaler.advance.interview_problems;

import java.util.Arrays;

public class NextPermutation {

    /**
     * Implement the next permutation, which rearranges numbers into the
     * numerically next greater permutation of numbers for a given array A of size N.
     *
     * If such arrangement is not possible, it must be rearranged as the lowest possible order,
     * i.e., sorted in ascending order.
     *
     * NOTE:
     *
     * The replacement must be in-place, do not allocate extra memory.
     * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify
     * your submission retroactively and will give you penalty points.
     *
     * Input 1:
     *
     *  A = [1, 2, 3]
     *
     *  Output 1:
     *
     *  [1, 3, 2]
     *
     *  Explanation 1:
     *
     *  Next permutaion of [1, 2, 3] will be [1, 3, 2].
     * @param args
     */
    public static void main(String[] args) {
        int [] arr = {1,1,1,2,1};

        //System.out.println(Arrays.toString(nextPermutation(arr)));

        System.out.println( PermutationStep(11121));
    }

    public static int PermutationStep(int num) {
        String nums = String.valueOf(num);
        char [] charArr = nums.toCharArray();
        int [] arr = new int[charArr.length];
        for (int i=0; i<charArr.length; i++) {
            arr[i] = Character.digit(charArr[i], 10);
        }
       int [] res = nextPermutation(arr);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<charArr.length; i++) {
            sb.append(res[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    //https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    private static int[] nextPermutation(int[] nums) {
        int ind1=-1;
        int ind2=-1;
        // step 1 find breaking point
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind1=i;
                break;
            }
        }
        // if there is no breaking  point
        if(ind1==-1){
            reverse(nums,0);
        }

        else{
            // step 2 find next greater element and swap with ind2
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[ind1]){
                    ind2=i;
                    break;
                }
            }

            swap(nums,ind1,ind2);
            // step 3 reverse the rest right half
            reverse(nums,ind1+1);
        }

        return nums;
    }

    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    static void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
