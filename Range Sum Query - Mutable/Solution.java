// Problem link: https://leetcode.com/problems/range-sum-query-mutable/description/
// Status: Accepted

class NumArray {
    
    private FenwickTree fenwickTree;

    public NumArray(int[] nums) {
        fenwickTree = new FenwickTree(nums);
    }
    
    public void update(int i, int val) {
        fenwickTree.update(i, val);
    }
    
    public int sumRange(int i, int j) {
        return fenwickTree.getSum(i, j);
    }
}

class FenwickTree {
    
    private int [] originalArray;
    private int [] tree;
    
    public FenwickTree(int[] nums) {
        originalArray = nums;
        tree = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            updateAllElements(i, originalArray[i - 1]);
        }
    }
    
    public void printTree() {
        for(int i = 0; i < tree.length; i++) System.out.println(i+":"+tree[i]);
    }
    
    private int get2sComplement(int num) {
        String bin = Integer.toBinaryString(num);
        char [] binInChar = bin.toCharArray();
        for(int i = 0; i < binInChar.length; i++) binInChar[i] = binInChar[i] == '0' ? '1' : '0';
        return Integer.parseInt(String.valueOf(binInChar), 2) + 1;
    }
    
    private int getParent(int i) {
        return i - (get2sComplement(i) & i);
    }
    
    private int getNext(int i) {
        return i + (get2sComplement(i) & i);
    }
    
    private int getSum(int i) {
        int sum = 0, next = i + 1;
        while(next > 0) {
            sum += tree[next];
            next = getParent(next);
        }
        return sum;
    }
    
    public int getSum(int i, int j) {
        if((i - 1) < 0) return getSum(j);
        return getSum(j) - getSum(i - 1);
    }
    
    public void update(int i, int val) {
        int differences = val - originalArray[i];
        originalArray[i] = val;
        updateAllElements(i + 1, differences);
    }
    
    private void updateAllElements(int i, int num) {
        int next = i;
        while(next <= originalArray.length) {
            tree[next] += num;
            next = getNext(next);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
