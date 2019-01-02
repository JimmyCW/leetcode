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
        ListNode result = null;
        if(l1 == null && l1 == null) {
            return null;
        }
        ListNode first = null,
                second = null;
        boolean firstFlag = false;
        boolean secondFlag = false;
        do {
            first = (first == null ? l1 : first.next);
            if(first == null) {
                firstFlag = true;
                first = new ListNode(0);
            }
            second = (second == null ? l2 : second.next);
            if(second == null) {
                secondFlag = true;
                second = new ListNode(0);
            }
            if(hasNext(l1) != null) {
                if(null == result) {
                    result = new ListNode(first.val + second.val);
                } else {
                    if(secondFlag && firstFlag) {
                        return result;
                    } else {
                        result.next = new ListNode(first.val + second.val);
                    }
                }
            } else {
                if(hasNext(l2) != null) {
                    while (hasNext(l2) != null) {
                        if(secondFlag && firstFlag) {
                            return result;
                        } else {
                            result.next = new ListNode(first.val + second.val);
                        }
                        first = (first == null ? l1 : first.next);
                        if(first == null) {
                            firstFlag = true;
                            first = new ListNode(0);
                        }
                        second = (second == null ? l2 : second.next);
                        if(second == null) {
                            secondFlag = true;
                            second = new ListNode(0);
                        }
                    }
                } else {
                    return result;
                }
            }
        } while (hasNext(l1) != null);
        return result;
    }


    public static ListNode hasNext(ListNode listNode) {
        if(listNode.next == null) {
            return null;
        } else {
            return listNode.next;
        }
    }

    public static void printListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder(listNode.val);
        while (hasNext(listNode) != null) {
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