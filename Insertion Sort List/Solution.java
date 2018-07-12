// Problem link: https://leetcode.com/problems/insertion-sort-list/description/
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
    private List<Integer> insertionSort(List<Integer> l) {
        int partialSort = 0, current = 1;
        while(current < l.size()) {
            while(current > 0 && l.get(current - 1) > l.get(current)) {
                int temp = l.get(current - 1);
                l.set(current - 1, l.get(current));
                l.set(current, temp);
                current--;
            }
            partialSort++;
            current = partialSort + 1;
        }
        return l;
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        List<Integer> unsortedL = new ArrayList<>();
        ListNode copiedHead = head;
        while(copiedHead != null) {
            unsortedL.add(copiedHead.val);
            copiedHead = copiedHead.next;
        }
        List<Integer> sortedL = insertionSort(unsortedL);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = new ListNode(sortedL.get(0));
        ListNode newHead = dummyHead.next;
        for(int i = 1; i < sortedL.size(); i++) {
            newHead.next = new ListNode(sortedL.get(i));
            newHead = newHead.next;
        }
        return dummyHead.next;
    }
}
