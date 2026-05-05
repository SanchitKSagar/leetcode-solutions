/**
 * LeetCode #61 - Rotate List
 * Difficulty : Medium
 * Topics     : Linked List, Two Pointers
 * Date       : 2026-05-05
 * URL        : https://leetcode.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }
        k %= len;
        if(k == 0)
            return head;
        
        ListNode p1 = head;
        ListNode p2 = head;

        while(k>0){
            p2 = p2.next;
            k--;
        }

        while(p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode temp =p1;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = head;

        ListNode tempHead = head;
        while(tempHead.next != p1)
            tempHead = tempHead.next;
        tempHead.next = null;
        
        return p1;
    }
}
