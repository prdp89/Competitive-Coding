package com.coding.leetcode.contests.biweekely.biweekely48;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DesignAuthManager {

    //Runtime: 80 ms
    //Memory Usage: 40.5 MB
    Map<String, int[]> map;
    HashSet<String> set;
    int time;

    //done by me :) except countUnexpiredTokens method
    public DesignAuthManager( int timeToLive ) {
        this.time = timeToLive;
        this.map = new HashMap<>();
        this.set = new HashSet<>();
    }

    //https://leetcode.com/contest/biweekly-contest-48/problems/design-authentication-manager/
    public static void main( String[] args ) {
        DesignAuthManager authManager = new DesignAuthManager(5);
        authManager.renew("aaa", 1);
        authManager.generate("aaa", 2);
        System.out.println(authManager.countUnexpiredTokens(6));

        authManager.generate("bbb", 7);
        authManager.renew("aaa", 8);
        authManager.renew("bbb", 10);
        System.out.println(authManager.countUnexpiredTokens(15));

    }

    public void generate( String tokenId, int currentTime ) {
        map.put(tokenId, new int[]{currentTime, currentTime + time});
    }

    public void renew( String tokenId, int currentTime ) {
        if (map.containsKey(tokenId)) {
            int[] times = map.get(tokenId);
            if (currentTime < times[1]) {
                map.put(tokenId, new int[]{currentTime, currentTime + time});
            } else {
                set.add(tokenId);
            }
        }
    }

    public int countUnexpiredTokens( int currentTime ) {
        int res = 0;
        for (String keys : map.keySet()) {
            if (map.get(keys)[1] > currentTime)
                res++;
        }

        return res;
    }
}
