package com.coding.scaler.advance.Recursion;

import java.util.ArrayList;

public class TowerOfHanoii {

    /**
     * In the classic problem of the Towers of Hanoi, you have 3 towers
     * numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom)
     * of different sizes which can slide onto any tower.
     * The puzzle starts with disks sorted in ascending order of size from top to bottom
     * (i.e., each disk sits on top of an even larger one).
     * You have the following constraints:
     *
     * Only one disk can be moved at a time.
     * A disk is slid off the top of one tower onto another tower.
     * A disk cannot be placed on top of a smaller disk.
     * You have to find the solution to the Tower of Hanoi problem.
     * You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
     * In each row, there should be 3 integers (disk, start, end), where:
     *
     * disk - number of the disk being moved
     * start - number of the tower from which the disk is being moved
     * end - number of the tower to which the disk is being moved
     *
     * Input 2:
     *
     * A = 3
     *
     * Output 2:
     *
     * [1 1 3 ] [2 1 2 ] [1 3 2 ] [3 1 3 ] [1 2 1 ] [2 2 3 ] [1 1 3 ]
     *
     *
     * Explanation 2:
     *
     * We can see that this was the only unique
     * path with minimal moves to move all disks from the first to the third tower.
     * @param args
     */
    public static void main(String[] args) {
        towerOfHanoi(3).forEach(System.out::println);
    }

   private static ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();

    private static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        toh(A,1,3,2);
        return result;
    }

    private static void toh(int disk,int from , int to,int helper){
        if(disk==0){
            return;
        }
        toh(disk-1,from,helper,to);
        ArrayList<Integer> subList=new ArrayList<>();
        subList.add(disk);
        subList.add(from);
        subList.add(to);
        result.add(subList);
        toh(disk-1,helper,to,from);

    }
}
