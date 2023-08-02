package com.coding.scaler.bit_manipulation;

public class NumberOf1SBit {

    public static void main(String[] args) {
        System.out.println( numSetBits(11));
        System.out.println( numSetBitsOptimal(11));
    }

    //but it returns TLE
    private static int numSetBits(int A) {
        int count = 0, temp = A, i = 0;
        while(A > 0) {
            if((A | (1 << i)) == A) //check for ith bit is set
                count++;

            A--;
            i++;
        }

        return count;
    }

    private static int numSetBitsOptimal(int A) {
        int count = 0;
        while(A > 0) {
            if((A & 1) == 1 ) //check for last bit is set only when number is ODD
                count++;

            A = A / 2;
        }

        return count;
    }
}
