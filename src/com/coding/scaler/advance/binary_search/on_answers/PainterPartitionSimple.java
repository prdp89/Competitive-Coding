package com.coding.scaler.advance.binary_search.on_answers;

public class PainterPartitionSimple {

    /**
     * Given N boards with the lengths of all boards.
     * a) All painter take T units of home to paint 1 unit of length.
     * b) A board can only be painted by 1 painter
     * c) A painter can only paint boards placed next to each other.
     * d)Find the min no. of painters required to paint all boards in X units
     * of time. Return -1 if not possible.
     *
     * Input:
     * arr= [5,3,6,1,9]
     * T = 2; X = 20
     *
     * For X units of time given, How many painters we need?
     *
     * Calculate time arr: [5*2, 3*2, 6*2, 1*2, 9*2]
     * time = [10, 6, 12, 2, 18]
     *
     *
     * If Job can be taken by one painter: [10, 6, 12, 2, 18] = 48
     *
     * If we apply 2 painter then partition can be:
     * Max[ (10) , (6 + 12 + 2 + 18)] = 38
     * Max[ (10 + 6) , (12 + 2 + 18)] = 32
     * Max[ (10 + 6 + 12) , (2 + 18)] = 28
     * Max[ (10 + 6 + 12 + 2) , (18)] = 30
     *
     * Min(38, 32, 28, 30) = 28
     *
     *If we apply 3 painter then partition can be:
     *
     * T = [10, 6, 12, 2, 18] = [[10,6], [12, 2], [18]] => min = 18 < 20 that means we need min 3 painters to finish the job.
     *
     * Output:
     *
     * 3
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findMinPainter(new int[] {5,3,6,1,9}, 2, 20));
    }

    private static int findMinPainter(int [] A, int T, int X) {
       int count = 1, sum = 0, n = A.length ; //Assuming that n> 0

        for(int i = 0; i<n; i++) {
            A[i] = A[i]*T;
        }

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
