class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++){
                if (grid[m][n]== '1') {
                    markIsland(grid, m, n, rows, cols);
                    numIslands++;
                }
            }
           
        }
        return numIslands;
    }
    private void markIsland(char[][] grid, int m, int n, int rows, int cols) {
        grid[m][n] = '0';
        if (m < rows - 1 && grid[m+1][n] == '1') markIsland(grid, m+1, n, rows, cols);

        if (m > 0 && grid[m-1][n] == '1') markIsland(grid, m-1, n, rows, cols);

        if (n < cols - 1 && grid[m][n+1] == '1') markIsland(grid, m, n+1, rows, cols);

        if (n > 0 && grid[m][n-1] == '1') markIsland(grid, m, n-1, rows, cols);

    }
}
