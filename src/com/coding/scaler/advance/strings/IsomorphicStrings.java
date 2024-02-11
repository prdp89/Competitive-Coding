package com.coding.scaler.advance.strings;

public class IsomorphicStrings {

    /**
     * Given two strings A and B, determine if they are isomorphic.
     *
     * A and B are called isomorphic strings if all occurrences of
     * each character in A can be replaced with another character to get B and vice-versa.
     *
     * Input 1:
     *
     * A = "aba"
     * B = "xyx"
     *
     * Output 1:
     *
     *  1
     *
     *
     * Explanation 1:
     *
     *  Replace 'a' with 'x', 'b' with 'y'.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve("vc", "aa"));
    }

    private static int solve(String A, String B) {
       return map(A, B) == 1 && map(B, A) == 1 ? 1 : 0;
    }

    private static int map(String A, String B) {
        int [] map = new int[26];

        for(int i=0; i<A.length(); i++) {

            int occ = map[A.charAt(i) - 'a'];
            if(occ != 0 && occ != (B.charAt(i) - 'a') + 1) {
                return 0;
            }

            map[A.charAt(i) - 'a'] = (B.charAt(i) - 'a') + 1;
        }
        return 1;
    }
}
