// Problem link: https://leetcode.com/problems/flatten-2d-vector/description/
// Status: Accepted

public class Vector2D implements Iterator<Integer> {
    private List<Integer> l;
    private int i, size;
    
    public Vector2D(List<List<Integer>> vec2d) {
        l = new ArrayList<Integer>();
        i = 0;
        for(List<Integer> innerList : vec2d) l.addAll(innerList);
        size = l.size();
    }

    @Override
    public Integer next() {
        return l.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < size;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
