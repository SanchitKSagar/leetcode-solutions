/**
 * LeetCode #2236 - Maximum Twin Sum of a Linked List
 * Difficulty : Medium
 * Topics     : Linked List, Two Pointers, Stack
 * Date       : 2026-06-14
 * URL        : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        ListNode h2 = slow.next;
        //display(head);
        int res = Integer.MIN_VALUE;
        while(h2!=null){
            res = Math.max(res, head.val + h2.val);
            h2 = h2.next;
            head = head.next;
        }
        return res;
    }

    public void display(ListNode h){
        while(h != null){
            System.out.print(h.val + " ");
            h = h.next;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode nxt = head.next;
        ListNode prev = null;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if(nxt != null)
                nxt = nxt.next;
        } 

        return prev;
    }
}
