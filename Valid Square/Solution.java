// Problem link: https://leetcode.com/problems/valid-square/description/
// Status: Accepted

class Solution {
    private double distance(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] pts = {p1, p2, p3, p4};
        Arrays.sort(pts, (pt1, pt2) -> pt1[0] == pt2[0] ? pt1[1] - pt2[1] : pt1[0] - pt2[0]);
        return distance(pts[0], pts[1]) != 0 && distance(pts[0], pts[1]) == distance(pts[1], pts[3]) &&
            distance(pts[1], pts[3]) == distance(pts[3], pts[2]) && distance(pts[3], pts[2]) == distance(pts[2], pts[0]) &&
            distance(pts[0], pts[3]) == distance(pts[2], pts[1]);
    }
}
