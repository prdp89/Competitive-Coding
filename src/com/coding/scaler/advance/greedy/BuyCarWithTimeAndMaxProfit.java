package com.coding.scaler.advance.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BuyCarWithTimeAndMaxProfit {

    /**
     * Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
     *
     * B[i] represents the profit you can earn by buying the ith car.
     * It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
     *
     * Your task is to find the maximum profit one can earn by buying cars
     * considering that you can only buy one car at a time.
     *
     * Input Format
     * The first argument is an integer array A represents the deadline for buying the cars.
     * The second argument is an integer array B represents the profit obtained after buying the cars.
     *
     * Input 1:
     *
     *  A = [1, 3, 2, 3, 3]
     *  B = [5, 6, 1, 3, 9]
     *
     *  Output 1:
     *  20
     *
     *  Explanation 1:
     *
     *  At time 0, buy car with profit 5.
     *  At time 1, buy car with profit 6.
     *  At time 2, buy car with profit 9.
     *  At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
     *  So, total profit that one can earn is 20.
     */
    private static class Pair {
        int time, profit;
        Pair(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 3, 2, 3, 3}, new int[] {5, 6, 1, 3, 9}));
    }

    private static int solve(int[] A, int[] B) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i=0; i<A.length; i++) {
            list.add(new Pair(A[i], B[i]));
        }

        list.sort((a,b)-> a.time - b.time);

        //PriorityQueue to have profit.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int time =0, totalProfit = 0;
        for (int i=0; i<A.length; i++) {
            Pair p = list.get(i);

            //buy the ith car when the current time <= A[i] - 1
            if(time <= p.time - 1) {
                priorityQueue.add(p.profit);
                time++;
            } else {
                //maximum profit one can earn by buying cars
                if(!priorityQueue.isEmpty() && priorityQueue.peek() < p.profit) {
                    priorityQueue.remove();
                    priorityQueue.add(p.profit);
                }
            }
        }

        while (!priorityQueue.isEmpty()) {
            totalProfit  = (totalProfit + priorityQueue.poll()) % 1000000007;
        }

        return totalProfit;
    }
}
