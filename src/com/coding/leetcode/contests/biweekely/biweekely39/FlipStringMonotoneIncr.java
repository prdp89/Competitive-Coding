package com.coding.leetcode.contests.biweekely.biweekely39;

public class FlipStringMonotoneIncr {

    //https://leetcode.com/problems/flip-string-to-monotone-increasing/
    public static void main( String[] args ) {
        String str = "010110";
        System.out.println(minFlipsMonoIncr(str));
    }

    //Runtime: 2 ms, faster than 99.11% of Java
    private static int minFlipsMonoIncr( String S ) {
        int countOne = 0, minFlipsReq = 0;
        for (char ch : S.toCharArray()) {

            //When '1' comes, no more flip should be applied, since '1' is appended to the tail of the original string.
            if (ch == '1') {
                countOne++;
            } else {
                //When '0' comes, two cases:
                //1: flip the newly appended '0' to '1'
                //2: or flip countOne '1' in the original string to '0'.
                minFlipsReq++;
            }

            //final res is min of both.
            minFlipsReq = Math.min(minFlipsReq, countOne);
        }
        return minFlipsReq;
    }
}
