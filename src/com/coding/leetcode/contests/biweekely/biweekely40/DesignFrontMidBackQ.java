package com.coding.leetcode.contests.biweekely.biweekely40;

import java.util.LinkedList;

public class DesignFrontMidBackQ {

    private LinkedList<Integer> q;

    //Runtime: 12 ms
    public DesignFrontMidBackQ() {
        q = new LinkedList();
    }

    //https://leetcode.com/problems/design-front-middle-back-queue/
    public static void main( String[] args ) {
        DesignFrontMidBackQ q = new DesignFrontMidBackQ();
        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);
        System.out.println(q.popFront());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popBack());
        System.out.println(q.popFront());
    }

    public void pushFront( int val ) {
        q.addFirst(val);
    }

    public void pushMiddle( int val ) {
        q.add(q.size() / 2, val);
    }

    public void pushBack( int val ) {
        q.addLast(val);
    }

    public int popFront() {
        return q.isEmpty() ? -1 : q.removeFirst();
    }

    public int popMiddle() {
        return q.isEmpty() ? -1 : q.remove((q.size() - 1) / 2);
    }

    public int popBack() {
        return q.isEmpty() ? -1 : q.removeLast();
    }
}
