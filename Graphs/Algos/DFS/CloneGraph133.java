package graphs.algos.dfs;
package graphs.algos.DFS;
package graphs.Algos.DFS;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /**Notes:
    1. While using recursion keep it simple, In most cases I don't have to use lengthy statements
    2. First, try to think if I could make use of the given method instead of creating a new method for
    recursion.
    3. Also think abour base case, and other cases where we might need the return from a statement 
    4. Once the above are sorted; think about one case that's all one fucking case and use recursion 
    do it again and again. */
    
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
    //Base case
    if(node == null){
        return node;
    }

    if(visited.containsKey(node)){
        return visited.get(node);
    }

    Node copy = new Node(node.val, new ArrayList<>());
    visited.put(node, copy);

    for(Node neighbor: node.neighbors){
        copy.neighbors.add(cloneGraph(neighbor));
    }

    return copy;
    }
}