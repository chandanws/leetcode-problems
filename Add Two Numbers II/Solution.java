// Problem link: https://leetcode.com/problems/add-two-numbers-ii/description/
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
    public ListNode addTwoNumbersUsingTwoStacks(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        ListNode l1Copy = l1;
        while(l1Copy != null) {
            s1.push(l1Copy);
            l1Copy = l1Copy.next;
        }
        Stack<ListNode> s2 = new Stack<ListNode>();
        ListNode l2Copy = l2;
        while(l2Copy != null) {
            s2.push(l2Copy);
            l2Copy = l2Copy.next;
        }
        int carry = 0;
        ListNode newHead = null;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if(!s1.isEmpty()) sum += s1.pop().val;
            if(!s2.isEmpty()) sum += s2.pop().val;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            if(newHead == null) newHead = node;
            else {
                node.next = newHead;
                newHead = node;
            }
        }
        if(carry == 1) {
            ListNode node = new ListNode(1);
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}
