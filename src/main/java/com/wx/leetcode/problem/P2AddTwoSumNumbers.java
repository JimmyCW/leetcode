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
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(18);

        printListNode(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null & l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode first = l1, second = l2, cur = result;
        int sum = 0;
        while (first != null || second != null) {
             if(first != null) {
                 sum += first.val;
                 first = first.next;
             }
             if(second != null) {
                 sum += second.val;
                 second = second.next;
             }
             cur.val = sum % 10;
             sum /= 10;
             if(first == null && second == null) {
                 continue;
             }
             cur.next = new ListNode(0);
             cur = cur.next;
        }
        if(sum > 0) {
            cur.next = new ListNode(sum);
        }
        return result;
    }



    public static void printListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder().append(listNode.val);
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