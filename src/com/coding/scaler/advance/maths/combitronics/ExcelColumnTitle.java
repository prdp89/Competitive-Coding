package com.coding.scaler.advance.maths.combitronics;

public class ExcelColumnTitle {

    /**
     * Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
     *
     * For example:
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *
     *     Input 1:
     *
     * A = 3
     * Input 2:
     *
     *
     * A = 27
     *
     * Output 1:
     *
     * "C"
     * Output 2:
     *
     * "AA"
     * @param args
     */
    public static void main(String[] args) {

    }

    private static String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();

        while(A > 0) {
            /**
             *     1 -> A
             *     2 -> B
             *     3 -> C
             *
             *     but we have to convert to 0 -> A ; 1 -> B etc
             *     so A --; is required.
             */
            A = A-1;
            int rem = A % 26;
            sb.append((char)('A' + rem));
            A = A / 26;
        }

        return sb.reverse().toString();
    }
}
