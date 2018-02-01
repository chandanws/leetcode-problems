// Problem link: https://stackoverflow.com/questions/7542952/singly-linked-list-in-java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
  public ListNode traverseInPair(ListNode head) {
    if(head == null || head.next == null) { return head; }
    ListNode newH = head;
    head = head.next;
    ListNode nextH = head.next;
    head.next = newH;
    newH.next = null;
    while(nextH != null) {
      if(nextH.next == null) {
        newH.next = nextH;
        nextH = null;
      } else {
        ListNode x = nextH;
        newH.next = nextH.next;
        nextH = nextH.next.next;
        x.next.next = x;
        x.next = null;
        newH = x;
      }
    }
    return head;
  }
}
