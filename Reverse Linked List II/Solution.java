// Problem link: https://leetcode.com/problems/reverse-linked-list-ii/description/
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
    private ListNode reverseList(ListNode head, ListNode tail) {
        ListNode currentNode = head;
        ListNode copiedHead = tail;
        while(currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = copiedHead;
            copiedHead = currentNode;
            currentNode = next;
        }
        return copiedHead;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int i = 0;
        ListNode currentNode = dummyHead;
        ListNode inFront = null, atBack = null;
        ListNode reverseFront = null;
        while(currentNode != null) {
            if(i + 1 == m) inFront = currentNode;
            if(i == m) reverseFront = currentNode;
            if(i == n) {
                atBack = currentNode.next;
                currentNode.next = null;
                currentNode = atBack;
                break;
            }
            currentNode = currentNode.next;
            i++;
        }
        ListNode rest = reverseList(reverseFront, atBack);
        inFront.next = rest;
        return dummyHead.next;
    }
}
