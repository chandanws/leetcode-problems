// Problem link: https://leetcode.com/problems/reverse-linked-list/description/
// Status: Accepted

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 
struct ListNode* reverseListIter(struct ListNode* head) {
    struct ListNode *newHead = NULL;
    while(head != NULL) {
        struct ListNode *next = head->next;
        head->next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
}

struct ListNode* helper(struct ListNode* head, struct ListNode* newHead) {
    if(head == NULL) return newHead;
    struct ListNode* next = head->next;
    head->next = newHead;
    newHead = head;
    head = next;
    return helper(head, newHead);
}

struct ListNode* reverseListRecur(struct ListNode* head) {
    return helper(head, NULL);
}
