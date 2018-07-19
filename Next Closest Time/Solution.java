// Problem link: https://leetcode.com/problems/next-closest-time/description/
// Status: Accepted

class Solution {
    private int findNextElement(int [] digits, int num) {
        for(int i = num + 1; i < 10; i++) if(digits[i] == 1) return i;
        return -1;
    }
    private int findSmallestElement(int [] digits) {
        for(int i = 0; i < 10; i++) if(digits[i] == 1) return i;
        return -1;
    }
    public String nextClosestTime(String time) {
        StringBuilder sb = new StringBuilder(time);
        int [] digits = new int[10];
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != ':') digits[sb.charAt(i) - '0'] = 1;
        }
        for(int i = sb.length() - 1; i >= 0; i--) {
            int nextElement = findNextElement(digits, sb.charAt(i) - '0');
            if(nextElement != -1) {
                if(i == 3 && nextElement > 5) continue;
                if(i == 1 || i == 0) {
                    int num = -1;
                    if(i == 1) num = Integer.parseInt((sb.charAt(0) - '0') + "" + nextElement);
                    else num = Integer.parseInt(nextElement + "" + (sb.charAt(1) - '0'));
                    if(num < 0 || num > 23) nextElement = findSmallestElement(digits);
                }
                sb.replace(i, i + 1, Integer.toString(nextElement));
                for(int j = i + 1; j < sb.length(); j++) {
                    if(sb.charAt(j) == ':') continue;
                    sb.replace(j, j + 1, Integer.toString(findSmallestElement(digits)));
                }
                break;
            }
        }
        return sb.toString();
    }
}
