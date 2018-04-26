// Problem link: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
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
    private ArrayList<ListNode> reverseList(ListNode head, ListNode rest) {
        ListNode currentNode = head;
        ListNode copiedHead = rest;
        while(currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = copiedHead;
            copiedHead = currentNode;
            currentNode = next;
        }
        return new ArrayList<>(Arrays.asList(copiedHead, head));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastTail = dummyHead;
        ListNode currentNode = head;
        int i = 1;
        while(currentNode != null) {
            if(i == k) {
                ListNode rest = currentNode.next;
                currentNode.next = null;
                ArrayList<ListNode> l = reverseList(lastTail.next, rest);
                lastTail.next = l.get(0);
                lastTail = l.get(1);
                currentNode = rest;
                i = 1;
            }
            if(currentNode != null) currentNode = currentNode.next;
            i++;
        }
        return dummyHead.next;
    }
}
