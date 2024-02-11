package com.coding.scaler.advance.maths.combitronics;

public class FindNCRModP {

    public static void main(String[] args) {
        System.out.println(solve(5,2,13));
    }

    /**
     * Given three integers A, B, and C, where A represents n, B represents r,
     * and C represents p and p is a prime number greater than equal to n,
     * find and return the value of nCr % p
     * where nCr % p = (n! / ((n-r)! * r!)) % p.
     *
     * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
     *
     *
     * (n! / ((n-r)! * r!)) % p can be written as:
     *
     * (n! * ([(n-r)!] ^ -1 * [r!] ^ -1 )) % p that can be expanded as:
     *
     * ((n!) % p * (  ([(n-r)!] ^ -1) % p  * ( [r!] ^ -1 )) % p ) % p
     *
     * part-1: (n!) % p
     *
     * part-2 : ([(n-r)!] ^ -1) % p
     *
     * part-3: ( [r!] ^ -1 ) % p
     *
     */

    /**
     * A = 5
     *  B = 2
     *  C = 13
     *
     *  Output 1:
     *
     *  10
     *
     *  Explanation 1:
     *
     *  nCr( n=5 and r=2) = 10.
     *  p=13. Therefore, nCr%p = 10.
     *
     */
    private static int solve(int A, int B, int C) {
        long p1 = part_one(A, C);
        long p2 = part_two(A, B, C);
        long p3 = part_three(B, C);

        long ans=(((p1%C)*
                (p2%C))%C*
                (p3%C))
                %C;

        return (int) ans;
    }

    // part-1: (n!) % p
    private static int part_one(int A, int C) {
        long fact=1;
        for( long i=2; i<=A;i++){
            fact=(fact*i %C )%C;
        }
        return (int)fact;
    }

    //part-2 : ([(n-r)!] ^ -1) % p == ((n-r)!)^P-2 % P
    private static int part_two(int A, int B, int C) {
        long fact=1;
        for( long i=2; i<=A-B;i++){
            fact=(fact*i %C)%C;
        }
        return pow((int)fact, C-2, C);
    }

    //part-3: ( [r!] ^ -1 ) % p == ((r!) ^ p-2) % p == PrimeModuloInverse
    private static int part_three(int B, int C) {
        long fact=1;
        for( long i=2; i<=B;i++){
            fact=(fact*i %C ) %C;
        }
        return pow((int)fact,C-2, C);
    }

    private static int pow(int a, int b, int c) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        if(a == 0)
            return 0;

        if(b == 0)
            return 1;

        long ha = pow(a, b/2, c);
        long hp = ((ha % c) * (ha % c)) % c;

        if(b % 2 == 1) {
            int x = (int) (((hp % c) * (a % c)) % c);
            if(x < 0){
                x+=c;
            }
            return x;
        } else {
            return (int) hp;
        }
    }
}
