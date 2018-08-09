// Problem link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/
// Status: Accepted

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 20000;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
