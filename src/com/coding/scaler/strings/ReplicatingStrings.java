package com.coding.scaler.strings;

import java.util.HashMap;

public class ReplicatingStrings {

    /**
     * Given a string B, find if it is possible to re-order the characters
     * of the string B so that it can be represented as a concatenation of A similar strings.
     *
     * Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab"
     * which is a concatenation of 2 similar strings "ab".
     *
     * If it is possible, return 1, else return -1.
     *
     * Input 1:
     *
     *  A = 2
     *  B = "bbaabb"
     *
     *  Output 1:
     *
     *  1
     *
     *
     *  Explanation 1:
     *
     *  We can re-order the given string into "abbabb".
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(2, "bbaabb"));
    }

    private static int solve(int A, String B) {

        int n = B.length();

        //if A is 1 that means each char coming atleast one time so we can replicate
        if(A == 1){
            return 1;//atleast one substring
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            map.put(B.charAt(i), map.getOrDefault(B.charAt(i), 0)+1);
        }

        for(char key : map.keySet()){
            if(map.get(key) < A){
                return -1;
            } else if(map.get(key) % A != 0) {
               return -1;
            }
        }
        return 1;
    }
}
