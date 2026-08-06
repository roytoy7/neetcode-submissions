class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                if (grid[m][n]==1) maxArea = Math.max(findArea(grid, m, n, rows, cols), maxArea);
            }
        }
        return maxArea;
    }
    private int findArea(int[][] grid, int m, int n, int rows, int cols) {
        if (m < 0 || m >= rows || n < 0 || n >= cols || grid[m][n]==0) return 0;
        
        grid[m][n] = 0;
        int area = 1;

        area += findArea(grid, m+1, n, rows, cols);
        area += findArea(grid, m-1, n, rows, cols);
        area += findArea(grid, m, n+1, rows, cols);
        area += findArea(grid, m, n-1, rows, cols);

        return area;
    }
}
