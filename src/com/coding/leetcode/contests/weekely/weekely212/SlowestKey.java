package com.coding.leetcode.contests.weekely.weekely212;

public class SlowestKey {

    //https://leetcode.com/contest/weekly-contest-212/problems/slowest-key/
    public static void main( String[] args ) {
        int[] releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";

        System.out.println(slowestKey(releaseTimes, keysPressed));
    }

    private static char slowestKey( int[] releaseTimes, String keysPressed ) {
        char c = keysPressed.charAt(0);
        int temp = releaseTimes[0];

        for (int i = 1; i < keysPressed.length(); i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] >= temp) {

                if (releaseTimes[i] - releaseTimes[i - 1] == temp)
                    c = keysPressed.charAt(i) > c ? keysPressed.charAt(i) : c;
                else
                    c = keysPressed.charAt(i);

                temp = releaseTimes[i] - releaseTimes[i - 1];
            }
        }

        return c;
    }
}
