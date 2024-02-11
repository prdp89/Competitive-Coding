package com.coding.scaler.arrays.two_pointers;

public class ThreeSortedArrayMaximizeTheMinDiff {

    /**
     * You are given 3 sorted arrays A, B and C.
     *
     * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
     *
     * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
     *
     * Input 1:
     *
     *  A = [1, 4, 10]
     *  B = [2, 15, 20]
     *  C = [10, 12]
     *
     *  Output 1:
     *
     *  5
     *
     *  Explanation 1:
     *
     *  With 10 from A, 15 from B and 10 from C.
     * @param args
     */
    public static void main(String[] args) {
        int [] a = {1, 4, 10};
        int [] b = {2, 15, 20};
        int [] c = {10,12};
        System.out.println(minimize(a, b, c));
        System.out.println(minimize_method2(a, b, c));
    }

    /**
     * If you didn't figure out that  max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
     * is same as max(A[i], B[j], C[k]) - min(A[i], B[j], C[k]), check out below way:
     */
    private static int minimize(final int[] A, final int[] B, final int[] C) {
        int p1 = 0, p2 = 0, p3 = 0;
        int i = A.length, j = B.length, k = C.length;
        int x = 0, y = 0, z = 0, max = 0, ans = Integer.MAX_VALUE;

        while(p1 < i && p2 < j && p3 < k) {
            x = Math.abs(A[p1] - B[p2]);
            y = Math.abs(B[p2] - C[p3]);
            z = Math.abs(C[p3] - A[p1]);

            max = Math.max(x, Math.max(y, z));
            ans = Math.min(ans, max);

            if(max == x) {
                if(A[p1] < B[p2]) {
                    p1++;
                }
                else {
                    p2++;
                }
            }
            else if(max == y) {
                if(B[p2] < C[p3]) {
                    p2++;
                }
                else {
                    p3++;
                }
            }
            else{
                if(C[p3] < A[p1]) {
                    p3++;
                }
                else {
                    p1++;
                }
            }
        }
        return ans;
    }

    private static int minimize_method2(final int[] A, final int[] B, final int[] C) {

        int p1 = 0, p2 = 0, p3 = 0;
        int i = A.length, j = B.length, k = C.length;
        int min = 0, max = 0, ans = Integer.MAX_VALUE;

        while(p1<i && p2<j && p3<k) {
            min = Math.min(A[p1], Math.min(B[p2], C[p3]));
            max = Math.max(A[p1], Math.max(B[p2], C[p3]));

            ans = Math.min(ans, max-min);

            if(A[p1] == min) {
                p1++;
            }
            else if(B[p2] == min) {
                p2++;
            }
            else {
                p3++;
            }
        }
        return ans;
    }
}
