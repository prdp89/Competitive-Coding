package com.coding.scaler.advance.bit_manipulation;

import java.util.Arrays;

public class FindTwoNumsAppearOnce {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solve(new int[] {1, 2, 3, 1, 2, 4}))
        );
    }

    private static int[] solve(int[] A) {
        int xor = 0;
        //eg: {3,6,4,4,3,8} = {6,8} = XOR = {14}
        for(int item : A) {
            xor ^= item;
        }

        //finding first set bit bcz from that SET bit we are partitioning the array by doing XOR in below for-loop.
        int i=0;
        while(!checkSetBit(xor, i)){
            i++;
        }

        int set = 0, unSet = 0;
        for(int num : A) {
            if(checkSetBit(num, i))
                set ^= num;
            else
                unSet ^= num;
        }

        return new int [] {Math.min(set,unSet),Math.max(set,unSet)};
    }

    private static boolean checkSetBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
