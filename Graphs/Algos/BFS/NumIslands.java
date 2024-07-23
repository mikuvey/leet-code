class Solution {
    public int numIslands(char[][] grid) {
        //Using BFS
        //We traverse through all the elements in the grid whenever we encounter 1 we perform BFS
        //And mark all the connected 1s (If they are child nodes)
        int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    public void bfs(char[][] graph, int i, int j){
        //Que data type is char && How to find it's child
        //All correct but we don't have to go through this headache, simpler code ahead LOL!
        //Cases:
        //1. Corners Top left (Right, Bottom), Top right(Left, Bottom), 
        //Bottom left(Top, Right), Bottom right(Top, left))
        //
        //2. Edges -> Children (left, Top, Bottom) or (Right, Top, Bottom)
        //3. Normal -> Children (Left, Top, Bottom, right)
        
        //Normal: (i, j-1), (i, j+1), (i+1, j), (i-1, j)
        //Edges: if(j==0 && (i!= 0 || i!= len-1) ->(i, j-1), (i+1, j), (i-1, j)
        // if(j==len-1 && (i!= 0 || i!= len-1)) -> (i, j+1),(i+1, j), (i-1, j)
        //Corners: if(i==0 && j==0) -> (i, j+1), (i+1, j); if(i==0 && j== len-1) -> (i, j-1), (i+1, j)
        //if(i== len-1 && j==0) -> (i-1, j), (i, j+1); if(i==len-1 && j==len-1) -> (i+1,j), (i,j-1)
        
        //Check NeetCode Solution Very Intutive 
        int numRows = graph.length;
        int numCols = graph[0].length;
        
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        que.add(new Pair<>(i, j));
        
        while(!que.isEmpty()){
            Pair<Integer, Integer> pair = que.remove();
            int r = pair.getKey();
            int c = pair.getValue();
            
            //Instead of writing cases this approach is simple where we check if a direction increment is possible or not for a case Simple as fuck
            //Check how Smashed my head before arriving here
            int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
            
            for(int[] dir: directions){
                int rCheck = r + dir[0];
                int cCheck = c + dir[1];
                
                if((rCheck >= 0 && rCheck < numRows) && (cCheck >= 0 && cCheck < numCols) && graph[rCheck][cCheck] == '1'){
                    que.add(new Pair<>(rCheck, cCheck));
                    graph[rCheck][cCheck] = '0';
                }
            }
            
            graph[r][c] = '0';
        }
    }
}