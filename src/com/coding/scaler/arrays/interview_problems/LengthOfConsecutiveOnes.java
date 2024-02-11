package com.coding.scaler.arrays.interview_problems;

public class LengthOfConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(solve("111011101"));
    }

    /**
     * Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
     * Find and return the length of the longest consecutive 1’s that can be achieved.
     * @param nums
     * @return
     */
    private static int solve(String nums) {

        int sum = 0;
        for(int i=0; i < nums.length(); i++) {
            sum += Character.getNumericValue(nums.charAt(i));

            if(sum > 0)
                break;
        }

        if(sum == 0)
            return 0;

        int s = 0, e = 0, countZeros = 0, n = nums.length(), ans = 0, k = 1;
        while (e < n) {

            //count zeros to flip it
            if(nums.charAt(e) == 0)
                countZeros++;

            if(countZeros > k) {

                //shrink/exclude from start since we need to include from end
                if(nums.charAt(s) == 0)
                    countZeros--;

                s++;
            }

            ans = Math.max(ans, e - s + 1);
            e++;
        }

        return ans;
    }
}
