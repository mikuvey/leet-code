package graphs.algos.bfs;
package graphs.algos.BFS;
package graphs.Algos.BFS;
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //Take aways: While deleaing with complex lists try to keep it as simple as possible else we will run into errors
        /*Theory:
        1. DS: Que, Lists<lists>, 
        2. So it's like this:
        3. In every iteration of Que I should store lists and check if we found the target 
        4. Else add it back to the list with current elements neighbors
        5. Eventually hoping the list will return atleast one path if the target exists */
        int len = graph.length;
        
        List<List<Integer>> paths = new ArrayList<>();
        
        Queue<List<Integer>> que = new LinkedList<>();
        que.add(new ArrayList<>(Arrays.asList(0))); //Use 0 directyly
        
        while(!que.isEmpty()){
            List<Integer> path = que.remove();
            
            //Take the last element
            int size = path.size() - 1;
            int curr = path.get(size);
            
            if(curr == len-1){
                paths.add(new ArrayList<>(path));
            }
            
            //Iterate over all the neighbor of current node and 
            //Create a list in each iteration and add them to the que
            for(int i: graph[curr]){
                List<Integer> newPath = new ArrayList<>(path); //Create new List 
                newPath.add(i);
                que.add(newPath);
            }
        }
        
        return paths;
    }
}