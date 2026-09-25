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
    public ListNode swapPairs(ListNode head) {
        // Dummy node to handle head edge cases smoothly
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Jab tak kam se kam 2 nodes bache hain swap karne ke liye
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Step 1: Re-wire the pointers
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Step 2: Move prev pointer forward for the next pair
            prev = first;
        }

        return dummy.next;
    }
}