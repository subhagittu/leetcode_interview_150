class Solution {
    public void solve(char[][] board) {
       int m = board.length;
       int n = board[0].length; 
       for(int i=0;i<n;i++)
       {
           if(board[0][i]=='O')
           {
               dfs(0,i,board);
           }
           if(board[m-1][i]=='O')
           {
               dfs(m-1,i,board);
           }
       }
       for(int i=0;i<m;i++)
       {
           if(board[i][0]=='O')
           {
               dfs(i,0,board);
           }
            if(board[i][n-1]=='O')
           {
               dfs(i,n-1,board);
           }
       }
        for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               if(board[i][j]=='O')
               {
                   board[i][j]='X';
               }
               if(board[i][j]=='Y')
               {
                   board[i][j]='O';
               }
           }
       }

    }
    public void dfs(int i,int j,char[][] grid)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ||grid[i][j]=='X' || grid[i][j]=='Y') return ;

        grid[i][j]='Y';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}
