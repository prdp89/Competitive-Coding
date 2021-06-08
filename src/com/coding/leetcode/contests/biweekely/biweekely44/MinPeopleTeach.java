package com.coding.leetcode.contests.biweekely.biweekely44;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinPeopleTeach {

    //https://leetcode.com/contest/biweekly-contest-44/problems/minimum-number-of-people-to-teach/
    public static void main( String[] args ) {
        int[][] lang = {
                {1},
                {2},
                {1, 2}
        };

        int[][] friendShip = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int n = 2;

        System.out.println(minimumTeachings(n, lang, friendShip));
    }

    //https://leetcode.com/problems/minimum-number-of-people-to-teach/discuss/1031102/Java-O(M*N)-Solution
    //Runtime: 267 ms, faster than 14.05% of Java
    private static int minimumTeachings( int n, int[][] languages, int[][] friendships ) {
        Map<Integer, Set<Integer>> languagesMap = new HashMap<>();

        //mapping the ith person with languages he knows..
        for (int i = 0; i < languages.length; i++) {
            languagesMap.put(i + 1, new HashSet<>());
            for (int l : languages[i]) {
                languagesMap.get(i + 1).add(l);
            }
        }

        //For each language 1..N And Each FriendShip bw {1st, 2nd} person
        //Checking: 1st person knows Jth lang AND 2nd Person knows Jth Lang; then only
        //both can communicate..
        boolean[] alreadyCan = new boolean[friendships.length];
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < friendships.length; i++) {
                if (languagesMap.get(friendships[i][0]).contains(j) && languagesMap.get(friendships[i][1]).contains(j)) {
                    alreadyCan[i] = true;
                }
            }
        }

        int minTeach = Integer.MAX_VALUE;

        //For each language 1..N And FriendShip bw {1, 2} person
        for (int i = 1; i <= n; i++) {
            Set<Integer> teachSet = new HashSet<>();

            //Checking if [j][0] doesn't know ith language; add to the set and Vice-versa
            for (int j = 0; j < friendships.length; j++) {
                if (alreadyCan[j]) continue;
                if (!languagesMap.get(friendships[j][0]).contains(i)) teachSet.add(friendships[j][0]);
                if (!languagesMap.get(friendships[j][1]).contains(i)) teachSet.add(friendships[j][1]);
            }

            minTeach = Math.min(teachSet.size(), minTeach);
        }
        return minTeach;
    }
}
