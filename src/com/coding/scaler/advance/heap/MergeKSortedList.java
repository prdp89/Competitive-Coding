package com.coding.scaler.advance.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {

    /**
     * Given a list containing head pointers of N sorted linked lists.
     * Merge these given sorted linked lists and return them as one sorted list.
     *
     * Input 1:
     *
     *  1 -> 10 -> 20
     *  4 -> 11 -> 13
     *  3 -> 8 -> 9
     *
     *  Output 1:
     *
     *  1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
     */
    private static class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
     }

    public static void main(String[] args) {

    }

    private static ListNode mergeKLists(ArrayList<ListNode> list) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode head: list)
            pq.add(head);

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while(!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            temp.next = minNode;
            temp = temp.next;

            //don't insert next node in PQ if next node is not null
            if(minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        return ans.next;
    }
}
