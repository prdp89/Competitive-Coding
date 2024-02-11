package com.coding.scaler.advance.linked_list;

public class KReverseLinkedList {

    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

   //https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    public static void main(String[] args) {

    }

    /**
     * Given a singly linked list A and an integer B, reverse the nodes of
     * the list B at a time and return the modified linked list.
     *
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5, 6]
     *  B = 2
     *
     *  Output 1:
     *
     *  [2, 1, 4, 3, 6, 5]
     *
     *  Explanation 1:
     *
     *  For the first example, the list can be reversed in groups of 2.
     *     [[1, 2], [3, 4], [5, 6]]
     *  After reversing the K-linked list
     *     [[2, 1], [4, 3], [6, 5]]
     */

    public ListNode reverseList(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseList(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
