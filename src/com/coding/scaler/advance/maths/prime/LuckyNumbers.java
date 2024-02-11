package com.coding.scaler.advance.maths.prime;

public class LuckyNumbers {

    public static void main(String[] args) {
        System.out.println(solve(12));
    }

    private static int solve(int A) {
        int [] spf = SPF(A);
        int res = 0;
        for(int i=2; i<=A; i++) {
            int item = i, total = 0;
            while(item != 1) {
                int p = spf[item];
                while(item % p == 0) {
                    item = item / p;
                }
                total++;
            }
            if(total == 2)
                res++;
        }
        return res;
    }

    private static int [] SPF(int n) {
        int [] spf = new int[n+1];

        //initialize with i for each number, consider that each number has smallest prime factor i.
        for(int i=0; i<=n; i++) {
            spf[i] = i ;
        }

        spf[0] = spf[1] = 0;

        for (int i=2; i<=n; i++) {

            //if number is itself the smallest prime factor, mark all next multiples of that i'th num.
            if(i == spf[i]) {
                for(int j=i*2; j <= n; j+=i) {

                    //let's say we are iterating for i = 5, so spf[i] = 5 initially
                    //next we move to 5*2 = 10 multiple and check if spf[10] which is 2 less than 5.
                    //so we spf[10] should be set as 2 only.
                    spf[j] = Math.min(i, spf[j]);
                }
            }
        }

        return spf;
    }

}
