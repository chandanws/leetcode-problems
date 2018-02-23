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
        int lengthA = 0, lengthB = 0;
        ListNode copyHeadA = headA, copyHeadB = headB;
        while(copyHeadA != null) {
            copyHeadA = copyHeadA.next;
            lengthA++;
        }
        while(copyHeadB != null) {
            copyHeadB = copyHeadB.next;
            lengthB++;
        }
        copyHeadA = headA;
        copyHeadB = headB;
        if(lengthA != lengthB) {
            ListNode longerLengthHead = lengthA > lengthB ? copyHeadA : copyHeadB;
            int i = Math.abs(lengthA - lengthB);
            while(i-- > 0) longerLengthHead = longerLengthHead.next;
            if(lengthA > lengthB) copyHeadA = longerLengthHead;
            else copyHeadB = longerLengthHead;
        }
        while(copyHeadA != copyHeadB) {
            copyHeadA = copyHeadA.next;
            copyHeadB = copyHeadB.next;
        }
        return copyHeadA;
    }
}
