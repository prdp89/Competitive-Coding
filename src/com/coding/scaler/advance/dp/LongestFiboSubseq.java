package com.coding.scaler.advance.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestFiboSubseq {

    /**
     * Given a strictly increasing array A of positive integers forming a sequence.
     *
     * A sequence X1, X2, X3, ..., XN is fibonacci like if
     *
     *
     * N > =3
     * Xi + Xi+1 = Xi+2 for all i+2 <= N
     * Find and return the length of the longest Fibonacci-like subsequence of A.
     *
     * If one does not exist, return 0.
     *
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5, 6, 7, 8]
     */
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))));
    }

    private static int solve(ArrayList<Integer> A) {
        if(A.size() == 0){
            return 0;
        }
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0;i<A.size();i++){
            hm.put(A.get(i),i);
        }
        int maxLength =0;
        for(int i=0;i<A.size();i++){

            for(int j=i+1;j<A.size();j++){
                int a = i, b=j, count =0;
                while(hm.containsKey(A.get(a)+A.get(b))){
                    int temp = b;
                    b = hm.get(A.get(a)+A.get(b));
                    a = temp;
                    count++;
                }

                if(count!=0){
                    //+2: bcz ist 2 numbers are already calculated from i and j.
                    count +=2;
                    maxLength = Math.max(maxLength,count);
                }
            }
        }
        return maxLength;
    }
}
