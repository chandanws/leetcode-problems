// Problem link: https://leetcode.com/problems/palindrome-linked-list/description/
// Status: Accepted

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool helper(struct ListNode** left, struct ListNode* right) {
    if(right == NULL) return true;
    if(!helper(left, right->next)) return false;
    if((*left)->val != right->val) return false;
    *left = (*left)->next;
    return true;
}

bool isPalindrome(struct ListNode* head) {
    return helper(&head, head);
}
