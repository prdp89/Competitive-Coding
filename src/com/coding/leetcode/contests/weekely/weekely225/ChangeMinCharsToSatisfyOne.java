package com.coding.leetcode.contests.weekely.weekely225;

public class ChangeMinCharsToSatisfyOne {

    //https://leetcode.com/contest/weekly-contest-225/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/
    public static void main( String[] args ) {
        System.out.println(minCharacters("aba", "caa"));
    }

    //feels similar to NumOfWaysSplitString in InterviewCLoned repo..
    //https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

    private static int minCharacters( String a, String b ) {
        int way3 = makeDistinct(a) + makeDistinct(b);
        int way12 = Math.min(makeLess(a, b), makeLess(b, a));
        return Math.min(way12, way3);
    }

    private static int makeDistinct( String s ) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        //Find the char which has the maximum count
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //let all other char be the char has maximum count
        return s.length() - max;
    }

    private static int makeLess( String s1, String s2 ) {
        int count = Integer.MAX_VALUE;
        int[] arr1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
        }
        for (int j = arr1.length - 2; j >= 0; j--) {
            arr1[j] = arr1[j] + arr1[j + 1];
        }
        int[] arr2 = new int[26];
        //prefixSumArray for s1 scan from right to left
        for (int i = 0; i < s2.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
        }
        //prefixSumArray for s2 scan from left to right
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i] + arr2[i - 1];
        }
        //if "a" is the bar, all "bcd..xyz" in s1 should move to "a"
        //and all "a" in s2 should move to "bcd..xyz"
        //Therefore you should add arr1[i+1] and arr2[i] and pick the minimum
        for (int i = 1; i < arr1.length; i++) {
            count = Math.min(count, arr1[i] + arr2[i - 1]);
        }
        return count;
    }
}
