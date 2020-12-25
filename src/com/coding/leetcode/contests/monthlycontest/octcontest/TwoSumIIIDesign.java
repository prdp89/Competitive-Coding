package com.coding.leetcode.contests.monthlycontest.octcontest;

import java.util.*;

public class TwoSumIIIDesign {

    //http://buttercola.blogspot.com/2015/08/leetcode-two-sum-iii-data-structure.html
    //https://leetcode.com/discuss/interview-question/algorithms/124696/linkedin-phone-screen-two-sum-iii
    private Set<Integer> set;
    private List<Integer> nums;
    private Map<Integer, Integer> map;

    TwoSumIIIDesign() {
        map = new HashMap<Integer, Integer>();
        set = new HashSet<>();
        nums = new ArrayList<>();
    }

    public static void main( String[] args ) {
        TwoSumIIIDesign twoSumIIIDesign = new TwoSumIIIDesign();

        System.out.println("Finding Value in O(N)");

        twoSumIIIDesign.add_bigo_1(1);
        twoSumIIIDesign.add_bigo_1(3);
        twoSumIIIDesign.add_bigo_1(5);
        twoSumIIIDesign.add_bigo_1(6);

        System.out.println(twoSumIIIDesign.find_bigo_n(4));
        System.out.println(twoSumIIIDesign.find_bigo_n(5));

        System.out.println("Finding Value in O(1) ...");
        //if we need to find in BigON

        twoSumIIIDesign.add_bigo_n(1);
        twoSumIIIDesign.add_bigo_n(3);
        twoSumIIIDesign.add_bigo_n(5);
        twoSumIIIDesign.add_bigo_n(6);

        System.out.println(twoSumIIIDesign.find_bigo_1(4));
        System.out.println(twoSumIIIDesign.find_bigo_1(5));
    }

    public void add_bigo_1( int number ) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find_bigo_n( int value ) {
        if (map.isEmpty())
            return false;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int firstKey = entry.getKey();
            int firstValue = entry.getValue();

            int secondKey = value - firstKey;

            //if firstKey = 1, value = 2, secondKey = 2 - 1 => 1
            //if firstKey == secondKey then, if 2 occurrence of firstValue found so return true.

            //---------or-----------
            // may be 0 + 0 = 0
            if (firstKey == secondKey && firstValue >= 2)
                return true;
            else if (firstKey != secondKey && map.containsKey(secondKey)) {
                return true;
            }
        }

        return false;
    }

    public void add_bigo_n( int input ) {
        if (!nums.isEmpty()) {
            for (int num : nums) {
                set.add(input + num);
            }
        }

        nums.add(input);
    }

    public boolean find_bigo_1( int val ) {
        return set.contains(val);
    }
}
