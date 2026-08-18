class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        HashSet<List<Integer>> pac = new HashSet<>();
        HashSet<List<Integer>> atl = new HashSet<>();
        
        for (int m = 0; m < rows; m++) {
           dfs(heights, pac, m, 0);
           dfs(heights, atl, m, cols-1);
        }
        for (int n = 0; n < cols; n++) {
           dfs(heights, pac, 0, n);
           dfs(heights, atl, rows-1, n);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> coord : pac) if (atl.contains(coord)) res.add(coord);
        return res;
        
    }

    private void dfs(int[][] heights, HashSet<List<Integer>> visited, int m, int n) {
        List<Integer> coord = List.of(m, n);
        
        if (visited.contains(coord)) return;
        
        visited.add(coord);

        int[][] direc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int[] dir : direc) {
            int newM = m+dir[0];
            int newN = n+dir[1];

            if (newM < 0 || newN < 0 || newM >= heights.length || newN >= heights[0].length) continue;
            if (heights[newM][newN] >= heights[m][n]) dfs(heights, visited, newM, newN);
        }

        
    }
}
