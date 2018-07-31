// Problem link: https://leetcode.com/problems/max-points-on-a-line/description/
// Status: Accepted

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    private int generateGCD(int a, int b) {
        if (b == 0) return a;
        else return generateGCD(b, a % b);
    }
    public int maxPoints(Point[] points) {
        if(points.length == 0) return 0;
        HashMap<String, Integer> hmPts = new HashMap<String, Integer>();
        for(Point pt : points) hmPts.put(pt.x + "," + pt.y, hmPts.getOrDefault(pt.x + "," + pt.y, 0) + 1);
        Point[] pointsWithoutDup = new Point[hmPts.size()];
        int k = 0;
        for(Map.Entry<String, Integer> entry : hmPts.entrySet()) {
            String [] eachPt = entry.getKey().split(",");
            pointsWithoutDup[k++] = new Point(Integer.parseInt(eachPt[0]), Integer.parseInt(eachPt[1]));
        }
        int max = hmPts.get(pointsWithoutDup[0].x + "," + pointsWithoutDup[0].y);
        for(int i = 0; i < pointsWithoutDup.length; i++) {
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            for(int j = 0; j < pointsWithoutDup.length; j++) {
                if(i == j) continue;
                int x = pointsWithoutDup[i].x - pointsWithoutDup[j].x;
                int y = pointsWithoutDup[i].y - pointsWithoutDup[j].y;
                if(x == 0 && y == 0) {
                    x = 1;
                    y = 1;
                }
                int gcd = generateGCD(x, y);
                if(gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if(hm.containsKey(x + "," + y)) {
                    hm.put(x + "," + y, hm.get(x + "," + y) + hmPts.get(pointsWithoutDup[j].x + "," + pointsWithoutDup[j].y));
                } else {
                    hm.put(x + "," + y, hmPts.get(pointsWithoutDup[i].x + "," + pointsWithoutDup[i].y) + 
                        hmPts.get(pointsWithoutDup[j].x + "," + pointsWithoutDup[j].y));
                }
                max = Math.max(max, hm.get(x + "," + y));
            }
        }
        return max;
    }
}
