package com.coding.scaler.advance.binary_search;

public class SingleElementSortedArr {

    //https://leetcode.com/problems/single-element-in-a-sorted-array/description/

    /**
     * You are given a sorted array consisting of only integers where every element appears exactly twice,
     * except for one element which appears exactly once.
     *
     * Return the single element that appears only once.
     *
     * Your solution must run in O(log n) time and O(1) space.
     *
     * Input: nums = [1,1,2,3,3,4,4,8,8]
     * Output: 2
     */

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
    }

    //check notes binary_search_one for clarity.
    private static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(nums.length == 1)
            return nums[0];

        int l =0, r = n-1;

        while(l <= r) {
            int mid = (l+r)/2;

            if((mid == 0 || nums[mid-1] != nums[mid]) &&
                    (mid == n - 1 || nums[mid+1] != nums[mid]) )
                return nums[mid];

            if(mid > 0 && nums[mid] == nums[mid-1]) {
                //this condition check we are at Odd-Even pattern
                //eg:       2 2 3 4 4
                //pattern   e o e o e
                //index:    0 1 2 3 4
                //mid % 2 == 0 check we at even index and we are on right part of array since (nums[mid] == nums[mid-1])
                //so better to move 2 indices to the left
                if(mid % 2 == 0){
                    r = mid - 2;
                } else
                {
                    //eg:       2 2 3 4 4
                    //pattern   e o e o e
                    //index:    0 1 2 3 4
                    //else we are at [0,1] indices, so move to the right
                    l = mid + 1;
                }
            } else { //(mid, mid+1) from the duplicate pair.
                // means we are sitting on left index and checking the right.
                if(mid % 2 == 0){
                    l = mid + 2;
                } else
                    r = mid - 1;
            }
        }

        return -1;
    }
}
