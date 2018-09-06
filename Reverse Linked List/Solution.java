// Problem link: https://leetcode.com/problems/reverse-linked-list/description/
// Live example link: https://repl.it/repls/FailingDeliciousAmericanindianhorse
// Status: Accepted

import java.util.*;

class Solution {
  public ListNode reverseListUsingArrayList(ListNode head) {
    if(head == null) { return null; }
    ArrayList<Integer> list = new ArrayList<Integer>();
    ListNode currentNode = head;
    while(currentNode != null) {
      list.add(currentNode.val);
      currentNode = currentNode.next;
    }
    int n = list.size();
    ListNode newNodeHead = new ListNode(list.get(n-1));
    currentNode = newNodeHead;
    for(int i = n-2; i >= 0; i--) {
      currentNode.next = new ListNode(list.get(i));
      currentNode = currentNode.next;
    }
    return newNodeHead;
  }
  public ListNode reverseListWithoutUsingArrayList(ListNode head) {
    ListNode newHead = null;
    while(head != null) {
      ListNode newNode = new ListNode(head.val);
      newNode.next = newHead;
      newHead = newNode;
      head = head.next;
    }
    return newHead;
  }
  public ListNode reverseListWithoutCreatingNewNode(ListNode head) {
    ListNode newHead = null;
    while(head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }
  // reverse linked list with recursion
  private ListNode newHead;
  private ListNode currentNode;
  private void helper(ListNode head) {
      if(head != null) {
          helper(head.next);
          if(newHead == null) {
              newHead = head;
              currentNode = newHead;
          } else {
              currentNode.next = head;
              currentNode = currentNode.next;
          }
      }
  }
  public ListNode reverseList(ListNode head) {
      newHead = null;
      currentNode = null;
      if(head == null) return newHead;
      helper(head);
      currentNode.next = null;
      return newHead;
  }
}
