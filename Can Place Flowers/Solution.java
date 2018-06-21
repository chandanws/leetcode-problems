// Problem link: https://leetcode.com/problems/can-place-flowers/description/
// Status: Accepted

class Solution {
    private boolean canPlant(int [] flowerbed, int pos) {
        if(flowerbed[pos] == 1) return false;
        int flowerbedSize = flowerbed.length;
        if(pos > 0 && pos + 1 < flowerbedSize) {
            if(flowerbed[pos - 1] == 1 || flowerbed[pos + 1] == 1) return false;
        } else {
            if(pos == 0 && flowerbedSize >= 2 && flowerbed[1] == 1 ||
               pos == flowerbedSize - 1 && flowerbedSize >= 2 && flowerbed[pos - 1] == 1) return false;
        }
        return true;
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowerbedSize = flowerbed.length;
        for(int i = 0; i < flowerbedSize; i++) {
            if(canPlant(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
