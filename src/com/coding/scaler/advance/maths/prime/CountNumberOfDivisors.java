package com.coding.scaler.advance.maths.prime;

public class CountNumberOfDivisors {

    /**
     * Given a number N, count it's divisors.
     *
     * E.g: N = 72 ==> 2 ^ 3 * 3 ^ 2 ==> [2^0, 2^1, 2^2, 2^3] [3^0, 3^1, 3^2] => so we do (3+1)*(2+1) => 12
     *
     * basically we are doing prime factorization of a number by dividing a Number by it's prime factor until we get 1.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countOfDivisors(72));
    }

    private static int countOfDivisors(int item) {
        int total = 1;
        int [] spf = SPF(item);

        //so, until Number turns 1, keep dividing with it's prime factor.
        while(item != 1) {
            int p = spf[item], count = 0;
            while(item % p == 0) {
                count = count+1;
                item = item / p;
            }
            //equals to (3+1) * (2+1)
            total *= count + 1;
        }
        return total;
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
