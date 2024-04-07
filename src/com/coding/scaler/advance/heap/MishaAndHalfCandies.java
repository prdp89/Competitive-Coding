package com.coding.scaler.advance.heap;

import java.util.PriorityQueue;

public class MishaAndHalfCandies {

    /**
     * Misha loves eating candies. She has been given N boxes of Candies.
     *
     * She decides that every time she will choose a box having the minimum number of candies,
     * eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
     *
     * Misha does not like a box if it has the number of candies greater than
     * B, so she won't eat from that box. Can you find how many candies she will eat?
     *
     * NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
     *
     * NOTE 2: The same box will not be chosen again.
     *
     * Input 1:
     *  A = [3, 2, 3]
     *  B = 4
     *
     *  Output 1:
     *  2
     *
     * Explanation 1:
     *
     *  1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
     *  2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
     *  She will not eat from the 3rd box as now it has candies greater than B.
     *  So the number of candies Misha eat is 2.
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {3, 2, 3}, 4));
    }

    private static int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int item: A) {
            pq.add(item);
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            if(val > B) {
                break;
            }

            //eat half of min candies
            int half = val/2;
            res += half;

            if(!pq.isEmpty()) {
                int currNext = pq.poll();
                //adding remaining candies to the next min box
                int sum = currNext + (val - half);
                pq.add(sum);
            }
        }
        return res;
    }
}
