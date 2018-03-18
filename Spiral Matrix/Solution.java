// Problem link: https://leetcode.com/problems/spiral-matrix/description/
// Status: Accepted

import java.util.Hashtable;
class Solution {
    private static Hashtable<String, Integer []> getPossibleMoves(int i, int j, HashSet<String> hs, int [][] matrix) {
        Hashtable<String, Integer []> possibleMoves = new Hashtable<>();
        int m = matrix.length;
        int n = matrix[0].length;
        // right
        if(j + 1 < n &&
          !hs.contains(i + "," + (j + 1))
        ) {
          possibleMoves.put("right", new Integer[]{i, j + 1});
        }
        // down
        if(i + 1 < m &&
          !hs.contains((i + 1) + "," + j)
        ) {
          possibleMoves.put("down", new Integer[]{i + 1, j});
        }
        // left
        if(j - 1 > -1 &&
          !hs.contains(i + "," + (j - 1))
        ) {
          possibleMoves.put("left", new Integer[]{i, j - 1});
        }
        // up
        if(i - 1 > -1 &&
          !hs.contains((i - 1) + "," + j)
        ) {
          possibleMoves.put("up", new Integer[]{i - 1, j});
        }
        return possibleMoves;
      }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if(matrix.length == 0) return results;
        String [] directions = new String[]{"right", "down", "left", "up"};
        int nextDirection = 0;
        HashSet<String> hs = new HashSet<>();
        int i = 0, j = 0;
        while(true) {
          hs.add(i + "," + j);
          results.add(matrix[i][j]);
          Hashtable<String, Integer[]> possibleMoves = getPossibleMoves(i, j, hs, matrix);
          if(!possibleMoves.containsKey(directions[nextDirection % 4])) {
            nextDirection++;
            if(!possibleMoves.containsKey(directions[nextDirection % 4])) break;
          }
          i = possibleMoves.get(directions[nextDirection % 4])[0];
          j = possibleMoves.get(directions[nextDirection % 4])[1];
        }
        return results;
    }
}
