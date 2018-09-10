// Problem link: https://leetcode.com/problems/merge-k-sorted-lists/description/
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
    public ListNode mergeKLists(ListNode [] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        }); 
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null) pq.add(lists[i]);
        while(!pq.isEmpty()) {
            currentNode.next = pq.poll();
            if(currentNode.next.next != null) pq.offer(currentNode.next.next);
            currentNode = currentNode.next;
        }
        return dummyHead.next;
    }
}
