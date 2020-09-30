package com.coding.leetcode.contests.weekely.weekely208;

import java.util.Stack;

public class CrawlerLogFolder {

    //https://leetcode.com/contest/weekly-contest-208/problems/crawler-log-folder/
    public static void main( String[] args ) {
        String[] strings = {"./", "../", "./"};
        System.out.println(minOperations(strings));
    }

    //TIME : 1 ms
    private static int minOperations( String[] logs ) {
        Stack<String> stack = new Stack<>();

        for (String log : logs) {

            if (log.equals("../") && !stack.isEmpty()) {
                stack.pop();
            } else if (!log.equals("./") && !log.equals("../")) {
                stack.push(log);
            }
        }

        return stack.size();
    }
}
