// Problem link: https://leetcode.com/problems/sort-list/description/
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
    private ListNode merge(ListNode leftH, ListNode rightH) {
        ListNode dummyHead = new ListNode(0), head = dummyHead;
        while(leftH != null && rightH != null) {
            if(leftH.val < rightH.val) {
                head.next = leftH;
                leftH = leftH.next;
            } else {
                head.next = rightH;
                rightH = rightH.next;
            }
            head = head.next;
        }
        head.next = leftH != null ? leftH : rightH;
        return dummyHead.next;
    }
    private ListNode mergeSort(ListNode head, int len) {
        if(len == 0 || len == 1) return head;
        ListNode leftH = head;
        for(int i = 0; i < len / 2 - 1; i++) head = head.next;
        ListNode rightH = head.next;
        head.next = null;
        return merge(mergeSort(leftH, len / 2), mergeSort(rightH, len - len / 2));
    }
    public ListNode sortList(ListNode head) {
        ListNode current = head;
        int len = 0;
        while(current != null) {
            current = current.next;
            len++;
        }
        return mergeSort(head, len);
    }
}
