// Problem link: https://leetcode.com/problems/linked-list-cycle-ii/description/
// Status: Accepted

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Did not modify the Linked List but used extra spaces. O(N) for space complexity.
    public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode currentNode = head;
        HashSet<ListNode> hs = new HashSet<ListNode>();
        while(currentNode != null) {
            if(hs.contains(currentNode)) return currentNode;
            hs.add(currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }
    // Did not modify the Linked List. Also, did not use extra space. Constant space complexity.
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head.next, fast = head.next.next, prevNode = null;
        while(fast != null) {
            if(slow == fast) break;
            prevNode = slow;
            slow = slow.next;
            if(fast.next == null) fast = fast.next;
            else fast = fast.next.next;
        }
        if(fast == null) return null;
        ListNode firstNode = prevNode, secondNode = slow;
        while(true) {
            ListNode currentNode = head;
            while(currentNode != firstNode && currentNode != secondNode) currentNode = currentNode.next;
            if(currentNode == secondNode) break;
            if(firstNode == prevNode && secondNode == slow) {
                firstNode = currentNode == prevNode ? prevNode : slow;
                secondNode = currentNode == prevNode ? slow : prevNode;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }
}
