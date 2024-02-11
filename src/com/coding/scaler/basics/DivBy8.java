package com.coding.scaler.basics;

public class DivBy8 {

    public static void main(String[] args) {
        System.out.println(solve("123"));
    }

    private static int solve(String A) {
        String s = "";
        int n = A.length();
        if(n>=3){
            for(int i=0;i<3;i++){
                s= A.charAt(n-1-i)+s;
            }
            return Integer.parseInt(s) % 8 ==0?1:0;
        }
        return Integer.parseInt(A) % 8==0?1:0;
    }
}
