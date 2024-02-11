package com.coding.scaler.advance.maths.combitronics;

public class ExcelNumberCol {

    /**
     * Given a column title as appears in an Excel sheet, return its corresponding column number.
     *
     * Input 1:
     *
     *  AB
     *
     *  Input 2:
     *
     *  BB
     *
     *  Output 2:
     *
     *  54
     *
     *  Output 1:
     *
     *  28
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( titleToNumber("BB"));
    }

    private static int titleToNumber(String A) {
        char [] arr = A.toCharArray();

        int pow =0, res = 0;
        for(int i=arr.length-1; i>=0; i--) {
            res =  res + (arr[i]- 'A' + 1) * (int) Math.pow(26, pow++);
        }

        return res;
    }
}
