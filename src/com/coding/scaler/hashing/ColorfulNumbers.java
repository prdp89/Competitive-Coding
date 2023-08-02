package com.coding.scaler.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ColorfulNumbers {

    public static void main(String[] args) {
        System.out.println(colorful(3245));
    }

    /**
     * A number can be broken into different consecutive sequence of digits.
     * The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
     * This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
     *
     * If number A is a COLORFUL number return 1 else, return 0.
     *
     * Input 1:
     *
     *  A = 23
     *
     *  Output 1:
     *
     *  1
     *
     *  Explanation 1:
     *
     *  Possible Sub-sequences: [2, 3, 23] where
     *  2 -> 2
     *  3 -> 3
     *  23 -> 6  (product of digits)
     *  This number is a COLORFUL number since product of every digit of a sub-sequence are different.
     */
    private static int colorful(int A) {
        List<Integer> list = new ArrayList();
        while(A > 0) {
            list.add(A % 10);
            A = A / 10;
        }

        int size = list.size();
        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < size; i++) {
            int sum = 1;
            for (int j = i; j < size; j++) {
                sum *= list.get(j);
                if(set.contains(sum)) {
                    return 0;
                }
                set.add(sum);
            }
        }

        return 1;
    }
}
