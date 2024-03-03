
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        /*
        Algorithm(BFS):
        1. Given edges, number of nodes, source and destination I should validate if there's a path
        2. Decalre a Queue; Add the source to the queue.
        3. While Queue is not empty:
            a. curr = Pop element of Queue 
            b. Check if the current node is destination -> break if found
            c. Add the current node to visited
            d. From the adjacency list add all the elements of the current node to the list*/
        
        //Adjacency lists
        List<List<Integer>> lists = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            lists.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        
        //Core Algo
        boolean valid = false;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        
        while(!que.isEmpty()){
            int curr = que.remove();
            
            //See if we reached target
            if(curr == destination){
                valid = true;
                break;
            }
            
            //Visited
            if(visited.contains(curr)){
                continue;
            }
            else{
                visited.add(curr);
            }
            
            //Add it's neighbors to que
            for(int i: lists.get(curr)){
                que.add(i);
            } 
        }
        
        return valid;
    }
}