// Problem link: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// Status: Accepted

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode** reverseLinkedList(struct ListNode* head) {
    struct ListNode** res = (struct ListNode**) malloc(sizeof(struct ListNode*) * 3);
    struct ListNode* newHead = NULL;
    struct ListNode* tail = head;
    while(head != NULL) {
        struct ListNode* next = head->next;
        head->next = newHead;
        newHead = head;
        head = next;
    }
    *res = newHead;
    *(res+1) = tail;
    return res;
}

struct ListNode* reverseKGroup(struct ListNode* head, int k) {
    struct ListNode* dummyHead = (struct ListNode*) malloc(sizeof(struct ListNode) * 2);
    dummyHead->val = 0;
    dummyHead->next = NULL;
    struct ListNode* lastModifiedNode = dummyHead;
    struct ListNode* currentNode = head;
    while(currentNode != NULL) {
        int i = 1;
        struct ListNode* lastHead = currentNode;
        while(currentNode != NULL && i++ < k) currentNode = currentNode->next;
        if(i - 1 == k) {
            struct ListNode* next = currentNode->next;
            currentNode->next = NULL;
            struct ListNode** nodes = reverseLinkedList(lastHead);
            lastModifiedNode->next = *nodes;
            (*(nodes+1))->next = next;
            lastModifiedNode = *(nodes+1);
            currentNode = next;
        }
    }
    return dummyHead->next == NULL ? head : dummyHead->next;
}
