package com.coding.leetcode.contests.biweekely.biweekely43;

public class MoneyLeetBank {

    //https://leetcode.com/contest/biweekly-contest-43/problems/calculate-money-in-leetcode-bank/
    public static void main( String[] args ) {
        int n = 10;
        System.out.println(totalMoney(n));
        System.out.println(totalMoney_O_N(n));
    }

    //couldn't think of logic :(
    private static int totalMoney( int n ) {
        if (n <= 7)
            return (n * (n + 1)) / 2;

        int res = 0, i = 0;
        while (n >= 7) {
            int temp = n % 7;
            temp += i;

            res = res + (temp * (temp + 1) / 2) - temp;
            n %= 7;
        }

        return res;
    }

    //time: O(N)
    //Runtime: 1 ms, faster than 65.35% of Java
    private static int totalMoney_O_N( int n ) {
        int s = 1, ans = 0;
        while (n > 0) {
            for (int i = 0; i < 7 && n-- > 0; i++)
                ans += (s + i);

            s++;
        }

        return ans;
    }
}
