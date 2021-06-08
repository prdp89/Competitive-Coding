package com.coding.leetcode.contests.weekely.weekely230;

public class ClosestDesertCost {

    private static int closest;

    //https://leetcode.com/contest/weekly-contest-230/problems/closest-dessert-cost/
    public static void main( String[] args ) {
        int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        int target = 10;

        closestCost(baseCosts, toppingCosts, target);

        System.out.println(closest);
    }


    //iterating for each base then try 3 possiblities for toppings (0, 1, 2)
    private static int closestCost( int[] baseCosts, int[] toppingCosts, int target ) {
        closest = Integer.MAX_VALUE;

        for (int base : baseCosts) {
            closestCostRecur(toppingCosts, 0, base, target);
        }

        return closest;
    }

    private static void closestCostRecur( int[] toppingCosts, int index, int baseCost, int target ) {
        if (Math.abs(target - baseCost) < Math.abs(target - closest)
                || Math.abs(target - baseCost) == Math.abs(target - closest)
                && baseCost <= target) {
            closest = baseCost; //updated baseCost by selecting either 0, 1, 2
        }

        if (index >= toppingCosts.length || baseCost > target)
            return;

        closestCostRecur(toppingCosts, index + 1, baseCost, target);
        closestCostRecur(toppingCosts, index + 1, baseCost + toppingCosts[index], target);
        closestCostRecur(toppingCosts, index + 1, baseCost + 2 * toppingCosts[index], target);
    }
}
