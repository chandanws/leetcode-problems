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

bool isPalindromeWithoutRecur(struct ListNode* head) {
    struct ListNode* fast = head;
    struct ListNode* slow = head;
    int size = 1;
    while(fast != NULL) {
        slow = slow->next;
        fast = fast->next;
        size++;
        if(fast != NULL) {
            fast = fast->next;
            size++;
        }
    }
    if(slow == NULL) return true;
    fast = head;
    struct ListNode* newHead = NULL;
    while(fast != slow) {
        struct ListNode* next = fast->next;
        fast->next = newHead;
        newHead = fast;
        fast = next;
    }
    if(size % 2 == 0) newHead = newHead->next;
    while(newHead != NULL && slow != NULL) {
        if(newHead->val != slow->val) return false;
        newHead = newHead->next;
        slow = slow->next;
    }
    return slow == NULL && newHead == NULL;
}
