package com.coding.scaler.arrays.twod_matrices;

import java.util.*;
import java.util.stream.Collectors;

public class PrintByCol {

    public static void main(String[] args) {
        int[][] twoDimArray = new int[][]{
                {1, 2, 3},
                {4, 5, 0},
                {7, 0, 9}

        };

        List<List<Integer>> nestedLists =
                Arrays.
                        //Convert the 2d array into a stream.
                                stream(twoDimArray).
                        //Map each 1d array (internalArray) in 2d array to a List.
                                map(
                                //Stream all the elements of each 1d array and put them into a list of Integer.
                                internalArray -> Arrays.stream(internalArray).boxed().collect(Collectors.toList()
                                )
                                //Put all the lists from the previous step into one big list.
                        ).collect(Collectors.toList());

      /*  System.out.println("Col sum:");

        solveColSum(nestedLists).forEach(System.out::println);

        System.out.println("Row sum:");
        solveRowSum(nestedLists).forEach(System.out::println);*/

       /* System.out.println("Matrix transpose:");
        solveMatrixTranspose(nestedLists).forEach(System.out::println);*/

       /* System.out.println("All Diagonals matrix:");
        diagonal(nestedLists).forEach(System.out::println);*/

        /*System.out.println("Scaler Multiply matrix:");
        scalerMultiply(nestedLists, 2).forEach(System.out::println);*/

        System.out.println("Fill Zero matrix:");
        fillRowColZero(nestedLists).forEach(System.out::println);
    }

    private static ArrayList<Integer> solveColSum(List<List<Integer>> list) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = list.size(), m = list.get(0).size();

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += (list.get(j).get(i));
            }
            res.add(sum);
        }
        return res;
    }

    private static ArrayList<Integer> solveRowSum(List<List<Integer>> list) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = list.size(), m = list.get(0).size();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += (list.get(i).get(j));
            }
            res.add(sum);
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> solveMatrixTranspose(List<List<Integer>> list) {
        int n = list.size(), m = list.get(0).size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                /*int temp = list.get(i).get(j);
                list.get(i).set(j, list.get(j).get(i));
                list.get(j).set(i, temp);*/
                temp.add(list.get(j).get(i));
            }
            res.add(temp);
        }

        ArrayList<ArrayList<Integer>> res2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = m - 1; j >= 0; j--) {

                temp.add(res.get(i).get(j));
            }
            res2.add(temp);
        }
        return res2;
    }

    //Nice implementation by me :)
    private static ArrayList<ArrayList<Integer>> diagonal(List<List<Integer>> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = list.size(), m = list.get(0).size();

        //looping column wise
        //this print Top row to bottom let
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(m, 0));
            for (int j = 0, k = i; j <= i && k < n; j++, k--) {
                //r++; c--
                temp.set(j, list.get(j).get(k));
            }
            res.add(temp);
        }

        //looping row wise
        //now start from ist row and print diagonal from row end to bottom left
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(m, 0));

            //why k =i => bcz last element start from i
            for (int j = m - 1, k = i, l = 0; j >= 0 && k < m; j--, k++, l++) {
                //r++; c--
                temp.set(l, list.get(k).get(j));
            }
            res.add(temp);
        }

        return res;
    }

    private static ArrayList<ArrayList<Integer>> scalerMultiply(List<List<Integer>> list, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = list.size(), m = list.get(0).size();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                temp.add(list.get(i).get(j) * B);
            }
            res.add(temp);
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> fillRowColZero(List<List<Integer>> list1) {
        int n = list1.size(), m = list1.get(0).size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(list1.get(i).get(j));
            }
            res.add(temp);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res.get(i).get(j) == 0) {
                    //set entire row to zero
                    for (int k = 0; k < m; k++) {
                        res.get(i).set(k, 0);
                    }

                    //set entire col to zero
                    for (int k = 0; k < n; k++) {
                        res.get(k).set(j, 0);
                    }
                }
            }
        }
        return res;
    }
}
