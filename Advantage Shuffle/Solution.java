// Problem link: https://leetcode.com/problems/advantage-shuffle/description/
// Status: Accepted

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int [] copyB = new int[B.length];
        for(int i = 0; i < B.length; i++) copyB[i] = B[i];
        Arrays.sort(B);
        HashMap<Integer, List<Integer>> ans = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int num : A) hm.put(num, hm.getOrDefault(num, 0) + 1);
        for(int i = 0; i < B.length; i++) {
            int index = Arrays.binarySearch(A, B[i]);
            if(index < 0) index = Math.abs(index) - 1;
            while((index < A.length && A[index] <= B[i]) || (index < A.length && !hm.containsKey(A[index]))) index++;
            if(index < B.length && hm.containsKey(A[index])) {
                hm.put(A[index], hm.get(A[index]) - 1);
                if(hm.get(A[index]) == 0) hm.remove(A[index]);
                if(ans.containsKey(B[i])) ans.get(B[i]).add(A[index]);
                else ans.put(B[i], new ArrayList<Integer>(Arrays.asList(A[index])));
            }
        }
        List<Integer> remainNum = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) remainNum.add(entry.getKey());
        }
        int k = 0;
        for(int i = 0; i < B.length; i++) {
            if(ans.containsKey(copyB[i]) && ans.get(copyB[i]).size() > 0) {
                A[i] = ans.get(copyB[i]).get(ans.get(copyB[i]).size() - 1);
                ans.get(copyB[i]).remove(ans.get(copyB[i]).size() - 1);
            }
            else A[i] = remainNum.get(k++);
        }
        return A;
    }
}
