package com.coding.leetcode.contests.biweekely.biweekely49;

import java.util.*;

public class SentenceSimilarityIII {

    //https://leetcode.com/contest/biweekly-contest-49/problems/sentence-similarity-iii/
    public static void main( String[] args ) {
        String sentence1 = "eTUny i b R UFKQJ EZx JBJ Q xXz", sentence2 = "eTUny i R EZx JBJ xXz";
        System.out.println(areSentencesSimilar(sentence1, sentence2));
    }

    //122 / 135 test cases passed.
    private static boolean areSentencesSimilar( String sentence1, String sentence2 ) {

        List<String> str1 = Arrays.asList(sentence1.split(" "));
        List<String> str2 = Arrays.asList(sentence2.split(" "));

        List<String> tmp = null;
        if (str1.size() > str2.size()) {
            tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        //Set<String> sentences_1 = new HashSet<>(str1);
        Set<String> sentences_2 = new HashSet<>(str2);

        if(!str1.get(0).equals(str2.get(0)))
            return false;

        for (String str : str1) {
            if(!sentence2.contains(str))
                return false;
        }

        return true;
    }

    //clean sol: https://leetcode.com/problems/sentence-similarity-iii/discuss/1140503/JavaPython-3-Two-codes-w-brief-explanation-and-analysis.
    public boolean areSentencesSimilar_dequeue(String s1, String s2) {
        Deque<String> dq1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> dq2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())) {
            dq1.poll();
            dq2.poll();
        }

        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }

        return dq1.isEmpty() || dq2.isEmpty();
    }
}
