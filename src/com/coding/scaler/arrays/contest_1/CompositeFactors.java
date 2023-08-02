package com.coding.scaler.arrays.contest_1;

import java.util.Arrays;

public class CompositeFactors {

    public static void main(String[] args) {
        int[] a = {16, 3, 3, 6, 7, 8, 17, 13, 7};
        int[][] b = {
                {2, 6},
                {4, 7},
                {6, 7},
        };

        System.out.println(Arrays.toString(solve(a, b)));
    }

    private static int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] prefix = new int[n];
        int item = A[0], factors = 0;
        prefix[0] = compositeFactors(item);

        for (int i = 1; i < n; i++) {
            item = A[i];
            factors = compositeFactors(item);
            prefix[i] = prefix[i - 1] + factors;
        }

        int[] res = new int[B.length];
        int j = 0;
        for (int[] q : B) {
            int l = q[0], r = q[1];
            if (l == 0) {
                res[j] = prefix[r];
            } else {
                res[j] = prefix[r] - prefix[l - 1];
            }
            j++;
        }

        return res;
    }

    private static int compositeFactors(int n) {
        int count = 0, sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (i != n / i)
                    count += 2;
                else
                    count += 1;
            }

            if (count > 2)
                return 1;
        }

        return 0;
    }
}
