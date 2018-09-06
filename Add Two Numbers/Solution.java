// Problem link: https://leetcode.com/problems/add-two-numbers/description/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        while(l1 != null || l2 != null || carry == 1) {
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            carry = sum / 10;
        }
        return dummyHead.next;
    }
}
