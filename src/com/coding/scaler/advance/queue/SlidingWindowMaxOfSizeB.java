package com.coding.scaler.advance.queue;

import java.util.*;

public class SlidingWindowMaxOfSizeB {

    //https://leetcode.com/problems/sliding-window-maximum/
    public static void main(String[] args) {
        slidingMaximum(new ArrayList<Integer>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7)), 3)
                .forEach(System.out::println);
    }

    private static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        //for the very first window
        for(int i=0;i<B;i++){
            while(dq.size()>0 && dq.peekLast()<A.get(i)){
                dq.removeLast();
            }
            dq.addLast(A.get(i));
        }
        ans.add(dq.peekFirst());

        //For the remaining window and checking we are not giving peek element which is out of the window
        for(int i=B;i<n;i++){
            while(dq.size()>0 && dq.peekLast()<A.get(i)){
                dq.removeLast();
            }
            dq.addLast(A.get(i));

            //slide the window if first element equals to top element of deque
            if(Objects.equals(dq.peekFirst(), A.get(i - B))){
                dq.removeFirst();
            }

            ans.add(dq.peekFirst());
        }

        return ans;
    }
}
