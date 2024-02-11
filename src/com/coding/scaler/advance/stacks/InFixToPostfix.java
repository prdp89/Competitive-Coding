package com.coding.scaler.advance.stacks;

import java.util.Stack;

public class InFixToPostfix {

    public static void main(String[] args) {
        System.out.println(solve("x^y/(a*z)+b"));
    }

    private static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack();

        for(int i = 0; i< A.length(); i++){
            char ch = A.charAt(i);

            //everything outside the bracket should append first.
            if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }

            else if(ch == '/' || ch == '*' || ch == '+' || ch == '-' || ch == '^'){
                while((st.size() > 0) && (st.peek() != '(') && (prio(ch) <= prio(st.peek()))){
                    //add the higher priority to answer
                    sb.append(st.pop());
                }
                st.push(ch);
            }

            else if( ch == '('){
                st.push(ch);
            }

            //closing bracket and inside content has higher priority so pick it first
            else if( ch == ')'){
                while(st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();
            }
        }

        // after itreating over string make the stack empty by appending all the character in sb.
        while(st.size() > 0){
            sb.append(st.pop());
        }

        return sb.toString();
    }

    private static int prio (char ch){
        int pr = 0;
        if(ch == '^'){
            pr = 3;
        }
        else if(ch == '*'  || ch == '/'){
            pr = 2;
        }
        else{
            pr = 1;
        }
        return pr;
    }
}
