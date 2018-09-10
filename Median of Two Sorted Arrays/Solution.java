// Problem link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// Status: Accepted

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m == 0) {
            return n % 2 == 0 ? (nums2[n / 2] + nums2[(n / 2) - 1]) / 2.0 : nums2[n / 2] * 1.0;
        } else if(n == 0) {
            return m % 2 == 0 ? (nums1[m / 2] + nums1[(m / 2) - 1]) / 2.0 : nums1[m / 2] * 1.0;
        } else if(m + n == 2) {
            return (nums1[0] + nums2[0]) / 2.0;
        }
        int i = m - 1, j = n - 1, k = (n + m) / 2;
        while(k > 0) {
            if(i >= 0 && j >= 0) {
                if(nums1[i] > nums2[j]) i--;
                else j--;
            } else if(i >= 0) i--;
            else j--;
            k--;
        }
        if((n + m) % 2 != 0) {
            if(i < 0) return nums2[j];
            else if(j < 0) return nums1[i];
            return nums1[i] > nums2[j] ? nums1[i] : nums2[j];
        }
        int sum = 0;
        if(i >= 0 && j >= 0) {
            sum = nums1[i] > nums2[j] ? nums1[i] : nums2[j];
        } else {
            sum = i < 0 ? nums2[j] : nums1[i];
        }
        if(i + 1 < m && j + 1 < n) {
            sum += nums1[i + 1] < nums2[j + 1] ? nums1[i + 1] : nums2[j + 1];
        } else {
            sum += i + 1 == m ? nums2[j + 1] : nums1[i + 1];
        }
        return sum / 2.0;
    }
}
