// Problem link: https://leetcode.com/problems/keys-and-rooms/description/
// Status: Accepted

class Solution {
    private void helper(List<List<Integer>> rooms, List<Integer> currentRoom, HashSet<Integer> hs) {
        for(Integer eachKey : currentRoom) {
            if(!hs.contains(eachKey)) {
                hs.add(eachKey);
                helper(rooms, rooms.get(eachKey), hs);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(0);
        helper(rooms, rooms.get(0), hs);
        return hs.size() == rooms.size();
    }
}
