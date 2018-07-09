// Problem link: https://leetcode.com/problems/linked-list-components/description/
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
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int g : G) hs.add(g);
        int totalComp = 0;
        boolean compStart = false;
        while(head != null) {
            if(hs.contains(head.val)) compStart = true;
            else if(compStart) {
                totalComp++;
                compStart = false;
            }
            head = head.next;
        }
        return compStart ? totalComp + 1 : totalComp;
    }
}
