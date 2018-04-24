// Problem link: https://leetcode.com/problems/add-digits/description/
// Status: Accepted

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode copiedEvenHead = evenHead;
        do {
            if(evenHead == null || evenHead.next == null) {
                oddHead.next = copiedEvenHead;
            } else {
                oddHead.next = oddHead.next.next;
                evenHead.next = evenHead.next.next;
                oddHead = oddHead.next;
                evenHead = evenHead.next;
            }
        } while(oddHead.next != copiedEvenHead);
        return head;
    }
}
