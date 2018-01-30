/**
 * Definition for Tree
 * public class Node {
 *     int val;
 *     Node right, left;
 *     Node(int x) { val = x; }
 * }
 */

public class Solution {
  public static Node testCase1() {
    return null;
  }
  public static Node testCase2() {
    return new Node(10);
  }
  public static Node testCase3() {
    Node head = new Node(1);
    head.right = new Node(3);
    head.right.right = new Node(4);
    head.right.right.left = new Node(5);
    head.right.right.left.right = new Node(6);
    head.left = new Node(2);
    head.left.left = new Node(7);
    head.left.left.right = new Node(10);
    head.left.right = new Node(8);
    head.left.right.left = new Node(9);
    head.left.right.left.right = new Node(11);
    return head;
  }
  public static void push(Stack<Node> s, Node node) {
    if(node != null) {
      s.push(node);
    }
  }
  public static void traverseInSpecialWay(Node head) {
    if(head == null) { return; }
    Stack<Node> s1 = new Stack<Node>();
    Stack<Node> s2 = new Stack<Node>();
    s1.push(head);
    for(int i = 0; !s1.empty() || !s2.empty(); i++) {
      Stack<Node> sPop = i % 2 == 0 ? s1 : s2;
      Stack<Node> sPush = i % 2 == 0 ? s2 : s1;
      while(!sPop.empty()) {
        Node node = sPop.pop();
        if(i % 2 == 0) {
          push(sPush, node.left);
          push(sPush, node.right);
        } else {
          push(sPush, node.right);
          push(sPush, node.left);
        }
        System.out.print(node.val + " ");
      }
    }
    System.out.println();
  }
  public static void main(String [] args) {
    traverseInSpecialWay(testCase1());
    traverseInSpecialWay(testCase2()); // 10
    traverseInSpecialWay(testCase3()); // 1 3 2 7 8 4 5 9 10 11 6
  }
}
