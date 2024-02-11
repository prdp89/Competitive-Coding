package com.coding.scaler.advance.maths.gcd;

public class AkillBReducePower {

    /**
     * There are N players, each with strength A[i]. when player i attack player j,
     * player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero,
     * it loses the game, and the game continues in the same manner among other players until only 1 survivor remains.
     *
     * Can you tell the minimum health last surviving person can have?
     *
     *  A = [2, 3, 4]
     *
     *  Output 1:
     *  2
     *
     *  Given strength array A = [6, 4]
     *  Second player attack first player, A =  [2, 4]
     *  First player attack second player twice. [2, 0]
     *
     *  GCD(a, b ) = GCD(b-a, a)
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {2, 3, 4}));
    }

    private static int solve(int[] A) {
        int ans = A[0];

        for(int i=1; i<A.length; i++) {
            ans = fungcd(ans, A[i]);
        }

        return ans;
    }

    private static int fungcd(int a, int b) {
        if(b <= 0)
            return a;

        return fungcd(b , a%b);
    }
}
