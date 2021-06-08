package com.coding.leetcode.contests.weekely.weekely234;

import java.util.*;

public class EvalBracketPairs {

    //https://leetcode.com/contest/weekly-contest-234/problems/evaluate-the-bracket-pairs-of-a-string/
    public static void main( String[] args ) {
        String s = "(name)is(age)yearsold";
        List<List<String>> lists = new ArrayList<>();

        List<String> list1 = Arrays.asList("name", "bob");
        lists.add(list1);

        List<String> list2 = Arrays.asList("age", "two");
        lists.add(list2);

        System.out.println(evaluate(s, lists));
    }

    //105 / 105 test cases passed.
    //Status: Accepted
    //Runtime: 37 ms

    //another good sol:https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/discuss/1131122/Java-HashMap-indexOf(String-fromIndex)
    private static String evaluate( String s, List<List<String>> knowledge ) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)))
                res.append(s.charAt(i));

            if (s.charAt(i) == '(') {
                StringBuilder tmp = new StringBuilder();
                while (s.charAt(i++) != ')') {
                    tmp.append(s.charAt(i));
                }

                String str = tmp.substring(0, tmp.length()-1);
                res.append(map.getOrDefault(str, "?"));
                i--;
            }
        }

        return res.toString();
    }
}
