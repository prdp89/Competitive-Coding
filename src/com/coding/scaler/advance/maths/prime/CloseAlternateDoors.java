package com.coding.scaler.advance.maths.prime;

public class CloseAlternateDoors {

    /**
     * Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.
     *
     * A person moves to and fro, changing the states of the doors as follows:
     * the person opens a door that is already closed and closes a door that is already opened.
     *
     * In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
     * In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
     * In the third go, he/she alters the states of doors numbered 3, 6, 9 …
     * This continues till the A'th go in, which you alter the state of the door numbered A.
     *
     * Find and return the number of open doors at the end of the procedure.
     *
     *
     * Input 1:
     *
     *  A = 5
     *
     *  Output 1:
     *
     *  2
     *
     *  In the first go, he/she alters the states of doors numbered 1, 2, 3, 4, 5. Now, all doors are open.
     *  In the second go, he/she closes the doors numbered 2, 4.
     *  In the third go, he/she closes the door numbered 3.
     *  In the fourth go, he/she open the door numbered 4.
     *  In the fifth go, he/she closes the door numbered 5.
     *  Doors opened at the end are 1 and 4.
     */
    public static void main(String[] args) {
        System.out.println( solve(5));
    }

    //Just by doing the dry run, we can observe that in the end, the doors which were open were nothing but perfect squares.
    private static int solve(int A) {
        int count = 0;
        for(int i = 1; i*i <= A; i++){
            count++;
        }
        return count;
    }
}
