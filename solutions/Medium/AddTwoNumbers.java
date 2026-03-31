/**
 * LeetCode #2 - Add Two Numbers
 * Difficulty : Medium
 * Topics     : Linked List, Math, Recursion
 * Date       : 2026-03-31
 * URL        : https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recAdd(l1,l2,0);
    }
    public ListNode recAdd(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null){
            if(carry == 0){
                return null;
            }
            else{
                return new ListNode(carry, null);
            }
        }
        else {
            if(l1 == null && l2 != null){
                int sum = l2.val + carry;
                return new ListNode(sum%10, recAdd(null, l2.next, sum/10));
            }
            else if(l1!=null && l2 == null){
                int sum = l1.val + carry;
                return new ListNode(sum%10, recAdd(l1.next, null, sum/10));
            }
        }
        

        int sum = l1.val + l2.val + carry;
        ListNode n = new ListNode(sum%10, recAdd(l1.next, l2.next, sum/10));
        return n;
    }
}
