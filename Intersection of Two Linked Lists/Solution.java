/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headACopy = headA;
        int lenOfAs = 0, lenOfBs = 0;
        while(headACopy != null) {
            lenOfAs++;
            headACopy = headACopy.next;
        }
        ListNode headBCopy = headB;
        while(headBCopy != null) {
            lenOfBs++;
            headBCopy = headBCopy.next;
        }
        if(lenOfAs > lenOfBs) {
            for(int i = lenOfAs; i > lenOfBs; i--) headA = headA.next;
        } else if(lenOfAs < lenOfBs) {
            for(int i = lenOfBs; i > lenOfAs; i--) headB = headB.next;
        }
        while(headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
