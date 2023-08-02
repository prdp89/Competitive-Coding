package com.coding.scaler.basics;

public class IsPrimNum {

    public static void main(String[] args) {
        System.out.println(solve(2L));

        int countOfPrime = 0;
        for(int i=1; i<=19; i++) {
            countOfPrime += solve((long)i);
        }

        System.out.println(countOfPrime);
    }

    public static int solve(Long A) {
        int res = 1;

        if(A == 1)
            return 0;

        if(A.intValue() == 2) {
            return 1;
        }

        if(A % 2 == 0)
            return 0;

        for(long i =3; i <= Math.sqrt(A); i+=2) {
            if(A % i == 0)
                return 0;
        }

        return res;
    }
}
