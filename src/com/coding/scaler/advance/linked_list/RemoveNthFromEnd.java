package com.coding.scaler.advance.linked_list;

public class RemoveNthFromEnd {

    class ListNode {
     public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    public static void main(String[] args) {

    }

    /**
     * Given a linked list A, remove the B-th node from the end of the list
     * and return its head. For example, Given linked list: 1->2->3->4->5, and B = 2.
     *
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * NOTE: If B is greater than the size of the list, remove the first node of the list.
     *
     * NOTE: Try doing it using constant additional space.
     *
     * nput 1:
     * A = 1->2->3->4->5
     * B = 2
     *
     * Output 1:
     * 1->2->3->5
     */
    public ListNode removeNthFromEnd(ListNode head, int B) {
        int count = 0;
        ListNode temp = head;
        while(temp != null ) {
            count++;
            temp = temp.next;
        }

        if (count == 1 || B > count) {
            return head.next;
        } else {
            int position = count - B;
            head = deleteFromPos(head, position);
            return head;
        }
    }

    public ListNode deleteFromPos(ListNode head, int idx) {
        if (idx == 0) {
            head = head.next;
            return head;
        } else {
            ListNode temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }
}
