package com.coding.scaler.strings;

public class AddBinaryStrings {

    /**
     * Given two binary strings A and B. Return their sum (also a binary string).
     *
     * Input 1:
     * A = "100"
     * B = "11"
     *
     * Output 1:
     * "111"
     */
    public static void main(String[] args) {
        System.out.println(addBinary("100", "11"));
    }

    private static String addBinary(String A, String B) {
        StringBuilder sb = new StringBuilder();
        StringBuilder n = new StringBuilder();

        for(int i=0;i<Math.abs(A.length()-B.length());i++)
            n.append('0');


        // adding zeros to smaller string to make both length of bits equal, which will be easy to calculate.
        if(A.length()>B.length())
            B = n + B;
        else
            A = n + A;;

        int carry = 0;
        int i = A.length()-1;  // as A and B both lengths are equal now

        while(i>=0)
        {
            if(A.charAt(i)=='1' && B.charAt(i)=='1')
            {
                if(carry==1)
                    sb.append('1');
                else
                    sb.append('0');
                carry=1;
            }
            else if(A.charAt(i)=='1'|| B.charAt(i)=='1')
            {
                if(carry==1)
                    sb.append('0');
                else
                    sb.append('1');
            }
            else
            {
                if(carry==1)
                    sb.append('1');
                else
                    sb.append('0');
                carry=0;
            }
            i--;
        }
        if(carry==1)
            sb.append('1');
        return sb.reverse().toString();

    }
}
