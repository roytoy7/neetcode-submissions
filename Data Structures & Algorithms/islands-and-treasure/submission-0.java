class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> qu = new LinkedList<>();

        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) if (grid[m][n]==0) qu.add(new int[]{m, n});
        }

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();

            int m = curr[0]; 
            int n = curr[1];

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};

            for (int[] dir : directions) {
                int newM = m + dir[0];
                int newN = n + dir[1];

                if (newM < 0 || newN < 0 || newM >= rows || newN >= cols || grid[newM][newN] != 2147483647) continue;

                grid[newM][newN] = grid[m][n] + 1;
                qu.add(new int[]{newM, newN});
            }
        }
    }
    
}
