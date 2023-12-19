class Solution {
public:
    void dfs(vector<vector<char>>& grid, int row, int col) {
        // Base cases for recursion
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid[0].size() || grid[row][col] != '1') {
            return;
        }
        
        // Mark the current cell as visited
        grid[row][col] = '2';
        
        // Recursive calls in 4 directions
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
    
    int numIslands(vector<vector<char>>& grid) {
        int islandCount = 0;
        
        // Traverse each cell in the grid
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid[0].size(); col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    dfs(grid, row, col);
                }
            }
        }
        
        return islandCount;
    }
};
