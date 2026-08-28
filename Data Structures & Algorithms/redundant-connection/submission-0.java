class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] par = new int[len];
        for (int i = 0; i < len; i++) par[i] = i+1; // parent is itself
        int[] rank = new int[len];
        Arrays.fill(rank, 1);

        for (int[] i: edges) {
            int n1 = i[0];
            int n2 = i[1];

            if (!union(n1, n2, par, rank)) return i;
        }
        return new int[]{0, 0};
    }
    private int find(int n, int[] par) {
        if (n!=par[n-1]) par[n-1] = find(par[n-1], par);
        
        return par[n-1];
    }
    private boolean union(int n1, int n2, int[] par, int[] rank) {
        int p1 = find(n1, par);
        int p2 = find(n2, par);
       
        if (p1==p2) return false;

        if (rank[p1-1] >= rank[p2-1]) {
            par[p2-1] = p1;
            rank[p2-1] += rank[p1-1];
        }
        else {
            par[p1-1] = p2;
            rank[p1-1] += rank[p2-1];
        }
        return true;
    }
}
