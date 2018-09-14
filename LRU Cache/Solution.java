// Problem link: https://leetcode.com/problems/lru-cache/description/
// Status: Accepted

class LRUCache {
    private int maxCapacity;
    private DListNode head, tail;
    private HashMap<Integer, DListNode> hm;
    
    public LRUCache(int capacity) {
        maxCapacity = capacity;
        head = new DListNode(0, 0);
        tail = new DListNode(0, 0);
        head.next = tail;
        tail.pre = head;
        hm = new HashMap<Integer, DListNode>();
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        DListNode node = hm.get(key);
        moveNodeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            hm.get(key).val = value;
            moveNodeToHead(hm.get(key));
        } else {
            DListNode newNode = new DListNode(key, value);
            hm.put(key, newNode);
            addNodeToHead(newNode);
            if(hm.size() > maxCapacity) {
                DListNode currentTail = popTail();
                hm.remove(currentTail.key);
            }
        }
    }
    
    public DListNode popTail() {
        DListNode currentTail = tail.pre;
        removeTheNode(currentTail);
        return currentTail;
    }
    
    public void moveNodeToHead(DListNode node) {
        removeTheNode(node);
        addNodeToHead(node);
    }
    
    public void removeTheNode(DListNode node) {
        DListNode pre = node.pre;
        DListNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    
    public void addNodeToHead(DListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
}

class DListNode {
    int key, val;
    DListNode pre, next;
    DListNode(int k, int v) {
        key = k;
        val = v;
        next = null;
        pre = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
