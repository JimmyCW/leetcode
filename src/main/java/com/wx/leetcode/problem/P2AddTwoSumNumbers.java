package com.wx.leetcode.problem;

/**
 *
 * You are given two non-empty linked lists representing
 * two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the
 * two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @author weixing
 * @date 2019/1/2
 **/
public class P2AddTwoSumNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        printListNode(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        if(l1 == null && l1 == null) {
            return null;
        }
        ListNode first = l1,
                second = l2,
                cur = null;
        int sum = 0;
        while (first.next != null || second.next != null) {
            if(first != null) {
                sum += first.val;
                first = first.next;
            }
            if(second != null) {
                sum += second.val;
                second = second.next;
            }
            cur = new ListNode(sum%10);
            cur.next = cur;
            sum /= 10;
        }

        return result;
    }




    public static void printListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            sb.append("->").append(listNode.val);
        }
        System.out.println(sb);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}