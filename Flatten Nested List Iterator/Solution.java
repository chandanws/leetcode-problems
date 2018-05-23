// Problem link: https://leetcode.com/problems/flatten-nested-list-iterator/description/
// Status: Accepted

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Queue<NestedInteger> q;

    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<NestedInteger>();
        for(NestedInteger node : nestedList) addIntegerOrListToQueue(q, node);
    }

    private void addIntegerOrListToQueue(Queue<NestedInteger> q, NestedInteger nestedNode) {
        if(nestedNode.isInteger()) q.offer(nestedNode);
        else for(NestedInteger node : nestedNode.getList()) addIntegerOrListToQueue(q, node);
    }

    @Override
    public Integer next() {
        return q.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
