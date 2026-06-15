/**
 * LeetCode #2216 - Delete the Middle Node of a Linked List
 * Difficulty : Medium
 * Topics     : Linked List, Two Pointers
 * Date       : 2026-06-15
 * URL        : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(!(fast == null || fast.next == null)){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = head;
        while(p.next!=slow){
            p = p.next;
        }
        p.next = slow.next;
        return head;
    }
}
