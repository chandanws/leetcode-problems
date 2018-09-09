// Problem link: https://leetcode.com/problems/rle-iterator/description/
// Status: Accepted

class RLEIterator {
    private long size;
    private int index;
    private long currentCount;
    private int [] arr;
    
    public RLEIterator(int [] A) {
        size = 0l;
        index = 0;
        currentCount = 0l;
        arr = A;
    }
    
    public int next(int n) {
        while(currentCount + n > size && index < arr.length) {
            size += arr[index];
            index = index + 2;
        }
        currentCount += n;
        if(currentCount <= size) return arr[index - 1];
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
