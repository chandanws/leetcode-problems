// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
// Live example link: https://repl.it/repls/GuiltyStickyGeese
// Status: Accepted

import java.util.*;

class Solution {
  public static RandomListNode testCase1() {
    HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
    RandomListNode head = new RandomListNode(1);
    RandomListNode currentNode = head;
    map.put(1, currentNode);

    currentNode.next = new RandomListNode(2);
    currentNode.random = currentNode;
    map.put(2, currentNode.next);

    currentNode = currentNode.next;

    currentNode.next = new RandomListNode(3);
    currentNode.random = map.get(1);
    map.put(3, currentNode.next);

    currentNode = currentNode.next;

    currentNode.next = null;
    currentNode.random = map.get(2);

    return head;
  }
  public static RandomListNode testCase2() {
    RandomListNode head = null;

    return head;
  }
  public static void printListNode(RandomListNode head) {
    RandomListNode currentNode = head;

    while(currentNode != null) {
      System.out.println("----------");
      System.out.print("Label: ");
      System.out.println(currentNode.label);
      System.out.print("Next: ");
      try {
        System.out.println(currentNode.next.label);
      } catch (java.lang.NullPointerException e) {
        System.out.println("null");
      }
      System.out.print("Random: ");
      try {
        System.out.println(currentNode.random.label);
      } catch (java.lang.NullPointerException e) {
        System.out.println("null");
      }
      currentNode = currentNode.next;
    }
  }
  public static RandomListNode assign(RandomListNode currentNode, HashMap<Integer, RandomListNode> map) {
    if(currentNode == null) {
      return null;
    }
    if(map.containsKey(currentNode.label)) {
      return map.get(currentNode.label);
    } else {
      RandomListNode newNode = new RandomListNode(currentNode.label);
      map.put(currentNode.label, newNode);
      return newNode;
    }
  }
  public static RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) {
      return head;
    }

    HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
    RandomListNode currentNode = head;
    RandomListNode copyNodeHead = new RandomListNode(head.label);
    RandomListNode currentCopyNode = copyNodeHead;
    map.put(head.label, copyNodeHead);

    while(currentNode != null) {
      currentCopyNode.next = assign(currentNode.next, map);
      currentCopyNode.random = assign(currentNode.random, map);
      currentNode = currentNode.next;
      currentCopyNode = currentCopyNode.next;
    }

    return copyNodeHead;
  }
  public static void main(String [] args) {
    printListNode(copyRandomList(testCase1()));
    printListNode(copyRandomList(testCase2()));
  }
}
