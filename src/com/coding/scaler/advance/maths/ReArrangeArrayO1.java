package com.coding.scaler.advance.maths;

import java.util.Arrays;

public class ReArrangeArrayO1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {4,0,2,1,3})));
    }

    private static int [] solve(int [] a) {

        //Input:            4  0  2  1  3

        //Output A[A[i]] :  3  4  2  0  1

        //encode value   :  19 20 12 1  8

        //We cannot simply replace A[A[i]] bcz we may loose A[i] info, so we need to encode A[i] info
        //such that 2 numbers group into 1. We may able to retrieve the number later as well.
        //Logic is to encode the number as:

        //Step1: go to A[0] : 4 + 5 * 3 ==> A[0] + A.length * A[A[i]] == 19 so later we can do 19 / 5 = 3 and 19 % 5 = 4; that way we encode 3 and 4
        //Step2: next go to A[1] => we first do : 19 % 5 = 4 => so we encode as: 0 + 5 * 4; only extra step is: A[A[i]] % n


        //final formula is: A[i] + ( A[A[i]] % N ) * N ==> where  A[A[i]] % N to extract previous encode value if exist
        //To Extract original from encoded extracted: A[i]/n

        int n = a.length;
        for(int i=0; i<n; i++) {
            int x = a[i];
            int y = a[a[i]];

            a[i] = x + (y % n) * n;
            //y%n : is equals to step 2: that find prev encoded value if exist.
        }

        for(int i=0; i<n; i++) {
            a[i] /= n;
        }

        return a;
    }
}
