package com.coding.scaler.bit_manipulation;

public class DecimalToAnyBase {

    /**
     * Given a decimal number A and a base B, convert it into its equivalent number in base B.
     *
     * Input 1:
     * A = 4
     * B = 3
     *
     * Output 1:
     * 11
     */
    public static void main(String[] args) {
        System.out.println(decimalToAnyBase(4, 3));
    }

    private static int decimalToAnyBase(int A, int B) {
        int sum =0, i = 0;
        while(A > 0) {
            //to convert to base B, divide and mod by B
            int lastDigit = A % B;

            //previous number is decimal so, 10^0, 1..
            sum += lastDigit * (int)Math.pow(10, i);

            i++;
            A = A / B;
        }

        return sum;
    }
}
