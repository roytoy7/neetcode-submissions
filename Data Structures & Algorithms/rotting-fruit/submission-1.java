class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> qu = new LinkedList<>();
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                if (grid[m][n]==1) fresh++;
                else if (grid[m][n]==2) qu.add(new int[]{m, n});
            }
        }
        int t = 0;

        while (!qu.isEmpty()&&fresh>0) {
            int s = qu.size();
            int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

            for (int i = 0; i < s; i++) {
                int[] curr = qu.poll();
                int m = curr[0];
                int n = curr[1];

                for (int[] dir : directions) {
                    int newM = m + dir[0];
                    int newN = n + dir[1];

                    if (newM >= rows || newN >= cols || newM < 0 || newN < 0) continue;
                    if (grid[newM][newN]==1) {
                        grid[newM][newN] = 2;
                        fresh--;
                        qu.add(new int[]{newM, newN});
                    }
                }
            }
            t++;
        }

        return (fresh>0) ? -1 : t;
        
    }
}
