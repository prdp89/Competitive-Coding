package com.coding.scaler.advance.binary_search.on_answers;

public class PainterPartitionReal {

    /**
     * Given 2 integers A and B and an array of integers C of size N.
     * Element C[i] represents the length of ith board.
     *
     * You have to paint all N boards [C0, C1, C2, C3 … CN-1].
     * There are A painters available and each of them takes B units of time to paint 1 unit of the board.
     *
     * Calculate and return the minimum time required to paint all boards under the constraints
     * that any painter will only paint contiguous sections of the board.
     *
     * Input:
     *      arr= [5,3,6,1,9]
     *      B = 2; //painter given
     *
     * If Job can be taken by one painter: [10, 6, 12, 2, 18] = 48
     *
     * If we apply 2 painter then partition can be:
     *      Max[ (10) , (6 + 12 + 2 + 18)] = 38
     *      Max[ (10 + 6) , (12 + 2 + 18)] = 32
     *      Max[ (10 + 6 + 12) , (2 + 18)] = 28
     *      Max[ (10 + 6 + 12 + 2) , (18)] = 30
     *
     *      Min(38, 32, 28, 30) = 28
     *
     *      If we apply 3 painter then partition can be:
     *      T = [10, 6, 12, 2, 18] = [[10,6], [12, 2], [18]] => min = 18
     *
     *      Next, we increase painter to 4 the time will still be : 18
     *
     *  Output: 18
     *
     *  That means, we have to search an answer in range of approx [ 1...SumOf(T[]) ] and find Min. time where
     *  Painter are less than equals to A.
     * @param args
     */
    public static void main(String[] args) {
       // System.out.println(painterPartition(new int[] {5,3,6,1,9}, 2, 20));
        System.out.println(painterPartition(new int[] {5,3,6,1,9}, 3, 2));
    }

    private static int painterPartition(int [] Arr, int A, int B) {
        int n = Arr.length, sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            Arr[i] = Arr[i]*B;

            max = Math.max(max, Arr[i]);

            sum += Arr[i];
        }

        //try various lower bounds; l =1, or l = sum/A etc
        int l = Math.max(max,sum/A), r = sum, ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r-l)/2;
            int req = findMinPainter(Arr, mid);
            if(req <= A) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static int findMinPainter(int [] A, int X) {
        int count = 1, sum = 0, n = A.length ; //Assuming that n> 0

        /*for(int i = 0; i<n; i++) {
            A[i] = A[i]*T;
        }*/

        for(int i = 0; i<n; i++) {

            if(A[i] > X) {
                return -1;
            }

            sum+= A[i];

            if(sum > X) {
                count++;
                sum = A[i];
            }
        }

        return count;
    }
}
