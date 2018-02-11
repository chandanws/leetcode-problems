// Problem link: https://leetcode.com/problems/minimum-time-difference/description/
// Status: Accepted

class Solution {
    private static int findDifference(String timePoint1, String timePoint2) {
        String [] t1 = timePoint1.split(":");
        String [] t2 = timePoint2.split(":");
        int a = Integer.valueOf(t1[0])*60+Integer.valueOf(t1[1]);
        int b = Integer.valueOf(t2[0])*60+Integer.valueOf(t2[1]);
        return Math.min(Math.abs(a-b), 60*24-b+a);
      }
    public int findMinDifference(List<String> timePoints) {
        HashSet<String> hs = new HashSet<>();
        List<String> distinctTimePoints = new ArrayList<>();
        for(int i = 0; i < timePoints.size(); i++) {
          if(!hs.contains(timePoints.get(i))) {
            hs.add(timePoints.get(i));
            distinctTimePoints.add(timePoints.get(i));
          } else {
            return 0;
          }
        }
        TreeSet<String> ts = new TreeSet<>();
        ts.addAll(distinctTimePoints);
        Iterator<String> iterator = ts.iterator();
        int minDifference = Integer.MAX_VALUE;
        String prevTimePoint = iterator.next();
        while(iterator.hasNext()) {
          String currentTimePoint = iterator.next();
          if(findDifference(prevTimePoint, currentTimePoint) < minDifference) {
            minDifference = findDifference(prevTimePoint, currentTimePoint);
          }
          prevTimePoint = currentTimePoint;
        }
        if(findDifference(ts.first(), ts.last()) < minDifference) {
          minDifference = findDifference(ts.first(), ts.last());
        }
        return minDifference;
    }
}
