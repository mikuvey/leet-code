package graphs;
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        //traverse through each one of the vertex in grid
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                //if grid[i][j] has neighbors as 1 then union
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid, i, j);
                }
            }    
        }

        return islands;
    }

    public void dfs(char[][] grid, int i, int j){
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if( i < 0 || j >= colLen || i >= rowLen || j < 0 || grid[i][j] == '0' ){
            return;
        }

        grid[i][j] = '0'; //Important step, I was thinking about creating Visiting set
        // However this was out of the box to think we could directly modify the array itsef 
        //instead of searching for those if the question doesn't mention about it.
        
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
    }
}