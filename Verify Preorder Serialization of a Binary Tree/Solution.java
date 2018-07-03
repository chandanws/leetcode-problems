// Problem link: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
// Status: Accepted

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean isValidSerialization(String preorder) {
        Pattern r = Pattern.compile("[0-9]+,#,#");
        Matcher m = r.matcher(preorder);
        while(m.find()) {
            preorder = preorder.replaceAll("[0-9]+,#,#", "#");
            m = r.matcher(preorder);
        }
        return preorder.equals("#");
    }
}
