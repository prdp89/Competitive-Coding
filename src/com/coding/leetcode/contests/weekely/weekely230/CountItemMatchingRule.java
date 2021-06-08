package com.coding.leetcode.contests.weekely.weekely230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemMatchingRule {
    //https://leetcode.com/contest/weekly-contest-230/problems/count-items-matching-a-rule/
    public static void main( String[] args ) {
        List<List<String>> lists = new ArrayList<>();

        List<String> list = new ArrayList<>(Arrays.asList("phone", "blue", "pixel"));
        lists.add(list);

        List<String> list1 = new ArrayList<>(Arrays.asList("computer", "silver", "phone"));
        lists.add(list1);

        List<String> list2 = new ArrayList<>(Arrays.asList("phone", "gold", "iphone"));
        lists.add(list2);

        System.out.println(countMatches(lists, "type", "phone"));
    }

    //Runtime: 4 ms
    //Memory Usage: 43.9 MB
    private static int countMatches( List<List<String>> items, String ruleKey, String ruleValue ) {
        int type = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;

        int count = 0;
        for (List<String> list : items) {
            count += list.get(type).equals(ruleValue) ? 1 : 0;
        }

        return count;
    }
}
