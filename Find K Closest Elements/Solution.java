// Problem link: https://leetcode.com/problems/find-k-closest-elements/description/
// Status: Accepted

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = Arrays.binarySearch(arr, x), i = index - 1, j = index + 1;
        if(index < 0) {
            index = Math.abs(index) - 1;
            i = index - 1;
            j = index;
        } else res.add(arr[index]);
        while(res.size() < k) {
            if(i < 0) res.add(arr[j++]);
            else if(j >= arr.length) res.add(0, arr[i--]);
            else {
                int diff1 = Math.abs(x - arr[i]), diff2 = Math.abs(arr[j] - x);
                if(diff1 > diff2) res.add(arr[j++]);
                else res.add(0, arr[i--]);
            }
        }
        return res;
    }
}
