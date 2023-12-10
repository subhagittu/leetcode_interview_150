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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start, end;
        start = new ListNode();
        start.next = head;
        for(int i = 0; i< left-1 && start != null; i++){
            start = start.next;
        }
        end = start;
        for(int i = left-2; i<right-1 && end != null; i++) {
            end = end.next;
        }
        ListNode s = start.next, e = end;
        end = end.next;
        ListNode prev = null, curr = s;
        while(curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        s.next = end;
        start.next = e;
        return head == s ? e : head;
    }
}
