// Problem link: https://leetcode.com/problems/palindrome-linked-list/description/
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
    private static ListNode reverseLinkedList(ListNode head, int size) {
        if(size % 2 != 0) { head = head.next; }
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        int size = 1;
        ListNode tempHead = head;
        while(tempHead.next != null) {
            tempHead = tempHead.next;
            size++;
        }
        int middle = size/2, i = 0;
        tempHead = head;
        while(i++ < middle - 1) { tempHead = tempHead.next; }
        ListNode newHead = tempHead.next;
        tempHead.next = null;
        newHead = reverseLinkedList(newHead, size);
        i = 0;
        while(i++ < middle) {
            if(head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
