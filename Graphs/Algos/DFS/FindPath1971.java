package graphs.algos.dfs

import java.util.*;

class FindPath1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //I have to use DFS to find the valid path between given vertices
        /*DFS: We use either internal stack/ Stack to perform this algorithm
        1. We put each node in stack, and check for connections for each node and also by marking current node visited.
        -> We could use a Hashset to check if a given node is visited or not;
        -> How about traversing? -> We have the edges array, Using them we can make connections, but how?
        -> I have seen the logic (now);
        */
        
        /*Algorithm:
        1. Declare a adjacency list i.e. either a List<List<>> or a HashMap<key, list>
        2. Now iterate through given edge array: For every vertex in the array add it's partner to it's respective position or key in adjacency list; vice versa
        3. Now Make use of a stack to perform DFS
        4. Place the source node into the stack
        5. Pop it out and check for it's edges in the adjacency list and place them one by one (iterate)  into the stack
        6. Now since the source node is seen, place it into a set, to make sure we don't check it's edges again
        7. Iterate the above step 3 till we find the target or till the stack is empty (which means not connected) */
        
        //Declare a Adjacency list and initalize it to size 0
        List<List<Integer>> adjLists = new ArrayList<>();
        
        //Initialize the Arraylist with size n Note: Using AL is better compared to Array because, we could get null point error and it's a headache to debug
        
        for(int i=0; i<n; i++){
            adjLists.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){ //Point 2
            adjLists.get(edge[0]).add(edge[1]);
            adjLists.get(edge[1]).add(edge[0]);
        }
        
        //Point 3
        Stack<Integer> stk = new Stack<>();
        
        Set<Integer> set = new HashSet<>(); //Seen DS
        
        //4
        stk.push(source);
        
        while(!stk.isEmpty()){
            int curr = stk.pop();
            
            //Check if it's the targe
            if(curr == destination){
                return true;
            }
            
            //Take curr arraylist if not seen
            if(set.contains(curr)) {
                continue;
            }
            else{
                set.add(curr);
            }
            
            //Iterate through curr arraylist and each vertex to stk
            List<Integer> al = adjLists.get(curr);
    
            for(int i: al){
                stk.push(i);
            }  
        }
        
        return false;
        
    }
}