package com.coding.leetcode.contests.weekely.weekely209;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {

    //https://leetcode.com/contest/weekly-contest-209/problems/even-odd-tree/
    public static void main( String[] args ) {
        TreeNode root = TreeNode.newNode(1);
        root.left = TreeNode.newNode(10);
        root.right = TreeNode.newNode(4);

        root.left.left = TreeNode.newNode(3);

        root.right.left = TreeNode.newNode(7);
        root.right.right = TreeNode.newNode(9);

        System.out.println(isEvenOddTree(root));
    }

    /*
    105 / 105 test cases passed.
    Status: Accepted
    Runtime: 14 ms
     */
    private static boolean isEvenOddTree( TreeNode root ) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean isEven = false;

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = q.poll();

                if (null != node) {

                    if ((!isEven && node.val % 2 == 1) || (isEven && node.val % 2 == 0))
                        list.add(node.val);
                    else
                        return false;

                    if (node.left != null)
                        q.offer(node.left);

                    if (node.right != null)
                        q.offer(node.right);
                }
            }

            if (isEven) {
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) >= list.get(i - 1))
                        return false;
                }
            } else {
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) <= list.get(i - 1))
                        return false;
                }
            }

            isEven = !isEven;
        }

        return true;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public static TreeNode newNode( int data ) {
            TreeNode node = new TreeNode();
            node.val = data;
            node.left = null;
            node.right = null;
            return node;
        }
    }

}
