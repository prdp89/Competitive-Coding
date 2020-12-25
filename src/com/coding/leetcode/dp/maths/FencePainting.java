package com.coding.leetcode.dp.maths;

import java.util.Scanner;

public class FencePainting {

    //https://www.youtube.com/watch?v=ju8vrEAsa3Q

    /*
    1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
    2. You are required to calculate and print the number of ways in which the fences could be painted so that not more
        than two fences have same colors.
     */
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        //N= 3 , k different colors (R,G,B) = 3
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long same = k * 1;
        long different = k * (k - 1);

        long total = same + different;

        for (int i = 3; i <= n; i++) {
            same = different * 1;
            different = total * (total - 1);

            total = same + different;
        }

        System.out.println(total);
    }
}
