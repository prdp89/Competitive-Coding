package com.coding.leetcode.contests.biweekely.biweekely36;

import java.util.*;

public class AlertKeyCard {

    public static void main( String[] args ) {
        String[] name = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] time = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};

        alertNames(name, time).forEach(System.out::println);
    }

    public static List<String> alertNames( String[] keyName, String[] keyTime ) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            map.putIfAbsent(keyName[i], new ArrayList<>());
            map.get(keyName[i]).add(convertTime(keyTime[i]));
        }

        List<String> res = new ArrayList<>();
        for (String str : map.keySet()) {
            List<Integer> list = map.get(str);
            Collections.sort(list);

            //check only if there's 3 entry for a person
            for (int i = 2; i < list.size(); i++) {
                if(list.get(i) - list.get(i-2) <= 60) {
                    res.add(str);
                    break;
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    private static Integer convertTime( String s ) {
        String[] ss = s.split(":");
        return Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
    }
}
