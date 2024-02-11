package com.coding.scaler.advance.Recursion;

import java.util.ArrayList;

public class CombinationSumOfSizeK {

    /**
     * Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.
     *
     * Make sure the combinations are sorted.
     *
     * To elaborate,
     *
     * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
     * Entries should be sorted within themselves.
     * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
     *
     * Input 1:
     *
     *  A = 4
     *  B = 2
     *
     *
     *  Output 1:
     *
     *  [
     *   [1, 2],
     *   [1, 3],
     *   [1, 4],
     *   [2, 3],
     *   [2, 4],
     *   [3, 4],
     *  ]
     * @param args
     */
    public static void main(String[] args) {
        combine(4,2).forEach(System.out::println);
    }

    private static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        exploreCombinations(1, A, B, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void exploreCombinations(int offset, int n, int k, ArrayList<Integer> partialCombination,
                                            ArrayList<ArrayList<Integer>> combinations) {

  /*
    If the partial combination we are building reaches the
    maximum size (which is k).
  */
        if (partialCombination.size() == k) {
            combinations.add(new ArrayList<>(partialCombination));
            return; //must include return bcz we have to just generate K size subsets
        }

  /*
    spaceLeftInSnippet <= n - i + 1:
      This is to assert that we can continue looping as long there are more
      choices left than 'slots' to fill. This is choice abundance. Imagine:
      n = 100
      k = 10

      and our state is:
      [ 95 _ _ _ _ _ _ _ _ _ ]
           ^
      Our for loop will start at 96 when expressing the possibility space for
      this "slot".
      We are now choosing for that slot. But now our possibility space is
      96...100
      spaceLeftInSnippet = 10 - 1 = 9
      n - i + 1 = 100 - 96 + 1 = 5 -> { 96, 97, 98, 99, 100 } which is length 5
      So if we recurse we will waste time. It is impossible to finish the k slots
      from this position, this conditional prunes the recursion.
  */

        //Prdp89 :
        //The above explanation means:
        //Suppose We have spaceLeft in partialCombination = 9 and,
        //We reach 96th index of array, that means we can't fill/complete partialCombination list with 5 elements left,
        //We are 4 elements short.

        final int spaceLeftInSnippet = k - partialCombination.size();
        for (int i = offset; i <= n && spaceLeftInSnippet <= n - i + 1; i++) {

            // 1.) Choose - Add the i'th number in the iteration
            partialCombination.add(i);

            // 2.) Explore - Recurse into our decision
            exploreCombinations(i + 1, n, k, partialCombination, combinations);

            // 3.) Unchoose - Remove the item we just explored on
            partialCombination.remove(partialCombination.size() - 1);
        }
    }


}
