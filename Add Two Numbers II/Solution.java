// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
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
    public static ListNode reverseListNode(ListNode head) {
        ListNode newH = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newH;
            newH = head;
            head = next;
        }
        return newH;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverseListNode(l1);
        ListNode rl2 = reverseListNode(l2);
        ListNode newH = null;
        int remaining = 0;
        while(rl1 != null || rl2 != null || remaining != 0) {
          int l1D = 0, l2D = 0;
          if(rl1 != null) {
            l1D = rl1.val;
            rl1 = rl1.next;
          }
          if(rl2 != null) {
            l2D = rl2.val;
            rl2 = rl2.next;
          }
          int sum = l1D + l2D + remaining;
          remaining = 0;
          if(sum > 9) {
            remaining = 1;
          }
          ListNode newNode = new ListNode(sum%10);
          newNode.next = newH;
          newH = newNode;
        }
        return newH;
    }
    // this does not work well with number that is larger than long can handle
    public ListNode addTwoNumbersWithoutUsingReverseLL(ListNode l1, ListNode l2) {
        int numberDigits1 = 0, numberDigits2 = 0;
        ListNode l1H = l1, l2H = l2;
        while(l1H != null) {
          numberDigits1++;
          l1H = l1H.next;
        }
        while(l2H != null) {
          numberDigits2++;
          l2H = l2H.next;
        }
        long sum1 = 0, sum2 = 0;
        l1H = l1;
        for(int i = numberDigits1 - 1; i >= 0; i--) {
          sum1 += (long)Math.pow(10, i)*l1H.val;
          l1H = l1H.next;
        }
        l2H = l2;
        for(int i = numberDigits2 - 1; i >= 0; i--) {
          sum2 += (long)Math.pow(10, i)*l2H.val;
          l2H = l2H.next;
        }
        long sum = sum1 + sum2, subSum = sum;
        String sumStr = Long.toString(sum);
        ListNode newH = null, currentNode = null;
        for(int i = 0; i < sumStr.length(); i++) {
          ListNode newNode = new ListNode(Character.getNumericValue(sumStr.charAt(i)));
          if(newH == null) {
            newH = newNode;
            currentNode = newH;
          } else {
            currentNode.next = newNode;
            currentNode = currentNode.next;
          }
        }
        return newH;
    }
}
