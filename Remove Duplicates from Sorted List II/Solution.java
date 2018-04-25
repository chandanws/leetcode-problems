// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode currentNode = head;
        ListNode lastUniqueNode = dummyHead;
        ListNode prevNode = head;
        int distance = 1;
        while(currentNode != null) {
            if(prevNode.val != currentNode.val) {
                if(distance == 2) {
                    lastUniqueNode = prevNode;
                } else {
                    lastUniqueNode.next = currentNode;
                }
                distance = 1;
            }
            distance++;
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if(distance > 2) lastUniqueNode.next = null;
        return dummyHead.next;
    }
}
