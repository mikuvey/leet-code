package DSA.Graphs.Algos.DFS;

import java.util.*;
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /*Algorithm: 
        1. Create an output lists of lists
        2. Write edge case for the algorithm i.e. if empty or have only 1 vertex in it
        3. Now DFS and we are done. LOl!
        4. (Think about the data we need to keep in track befor we use recursion)
        5. DFS(vertex, path, paths, graph):
            a. if we got to the end of graph array -> push the (new)path to paths and return
            b. In for loop Iterate through each of the neighbors of current node and Do DFS and backtrack for exploring all the possiblities*/
        
        List<List<Integer>> paths = new ArrayList<>();
        
        dfs(0, new ArrayList<>(), paths, graph);
        return paths;
   
    }
    
    public void dfs(int node, List<Integer>path, List<List<Integer>>paths, int[][] graph ){
        path.add(node); //Like Pop and current node incase of using an actual stack
        
        //Base Case
        if(node == graph.length-1){
            paths.add(new ArrayList<>(path)); //We are adding current path as a new List to paths so that we could add more paths
            return;
        }
        
        int[] adjs = graph[node];
        for(int neighbours: adjs){
            dfs(neighbours, path, paths, graph); //Do DFS for every single neighbor of neighbors untill u know who is found
            //BackTrack
            path.remove(path.size()-1); //This was the part where I was initially struggled with as the idea of backtracking was new for me
            //So if you are confused, think of this way once we encounter the base case in recursion we roll back till we go to where we started right
            //In that process in every roll back we decrease our path size as well, it's like if we are at 0th node now then elements in path is also [0]
        }
    }
}

