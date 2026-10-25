class Solution {
    public int closedIsland(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;

        for(int j=0; j<n; j++){
            if(grid[0][j] ==0){
                dfs(0,j,grid);
            }

            if(grid[m-1][j]==0){
                dfs(m-1, j, grid);
            }
        }

        for(int i=0; i<m; i++){
            if(grid[i][0]==0){
                dfs(i,0,grid);
            }

            if(grid[i][n-1]==0){
                dfs(i,n-1, grid);
            }
        }

        int count=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j]==0){
                    count++;

                    dfs(i,j,grid);
                }
            }
        }

        return count;

    }

    public void dfs(int row, int col , int [][] grid){
        
        if(row<0 || row >=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=0){
            return ;
        }

        grid[row][col]=1;

        dfs(row-1, col, grid);
        dfs(row+1, col, grid);
        dfs(row, col-1, grid);
        dfs(row, col+1, grid);
    }
}