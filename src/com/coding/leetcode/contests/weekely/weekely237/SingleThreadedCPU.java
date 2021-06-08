package com.coding.leetcode.contests.weekely.weekely237;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    //https://leetcode.com/problems/single-threaded-cpu/
    public static void main( String[] args ) {
        int[][] tasks = {
                {1, 2},
                {2, 4},
                {3, 2},
                {4, 1}
        };

        System.out.println(Arrays.toString(getOrder(tasks)));
    }

    //Runtime: 157 ms, faster than 45.91% of Java
    private static int[] getOrder( int[][] tasks ) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(( x, y ) -> x.enqueueTime - y.enqueueTime),
                availableQueue = new PriorityQueue<>(( x, y ) -> x.processingTime != y.processingTime ?
                        x.processingTime - y.processingTime : x.index - y.index);

        int[] result = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++)
            taskQueue.offer(new Task(i, tasks[i][0], tasks[i][1]));

        //initially currentTime = 1
        int index = 0, currentTime = taskQueue.peek().enqueueTime;

        while (!taskQueue.isEmpty() || !availableQueue.isEmpty()) {
            while (!taskQueue.isEmpty() && taskQueue.peek().enqueueTime <= currentTime)
                availableQueue.offer(taskQueue.poll());

            if (!availableQueue.isEmpty()) {
                //now CurrentTime = 1 + 2 = 3 required to process current item
                //in next iteration we can pick the task that are less than 3
                currentTime = currentTime + availableQueue.peek().processingTime;
                result[index++] = availableQueue.poll().index;
            } else
                currentTime = taskQueue.peek().enqueueTime;
        }
        return result;
    }

    static class Task {
        int index, enqueueTime, processingTime;

        public Task( int index, int enqueueTime, int processingTime ) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
}
