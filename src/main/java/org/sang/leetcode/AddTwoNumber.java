package org.sang.leetcode;


/**
 * @author fanker
 * input : (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * output ： （7 -> 8 -> 0)
 * reason: 342 + 465 = 780
 */
public class AddTwoNumber {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode util(ListNode listNode1, ListNode listNode2) {
        ListNode listNode = null;
        ListNode lastNode = null;
        int val;
        int val1;
        int val2;
        int nextVal = 0;
        while (listNode1 != null || listNode2 != null || nextVal != 0) {
            val1 = listNode1 == null ? 0 : listNode1.val;
            val2 = listNode2 == null ? 0 : listNode2.val;
            val = val1 + val2 + nextVal;
            nextVal = val / 10;
            val = val % 10;
            if (lastNode == null) {
                lastNode = new ListNode(val);
                listNode = lastNode;
            } else {
                lastNode.next = new ListNode(val);
                lastNode = lastNode.next;
            }
            listNode1 = listNode1 == null ? null : listNode1.next;
            listNode2 = listNode2 == null ? null : listNode2.next;
        }
        return listNode;
    }
}
