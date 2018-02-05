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
        int remain = 0;
        ListNode answerHead = null, currentNode = null;
        while(l1 != null || l2 != null) {
          int sum = remain;
          if(l1 != null) {
            sum += l1.val;
            l1 = l1.next;
          }
          if(l2 != null) {
            sum += l2.val;
            l2 = l2.next;
          }
          if(sum > 9) {
            sum -= 10;
            remain = 1;
          } else {
            remain = 0;
          }
          if(currentNode != null) {
            currentNode.next = new ListNode(sum);
            currentNode = currentNode.next;
          } else {
            currentNode = new ListNode(sum);
            answerHead = currentNode;
          }
        }
        if(remain == 1) {
          currentNode.next = new ListNode(1);
        }
        return answerHead;
    }
}
