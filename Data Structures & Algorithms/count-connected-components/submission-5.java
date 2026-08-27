class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (!hm.containsKey(n1)) hm.put(n1, new ArrayList<>());
            if (!hm.containsKey(n2)) hm.put(n2, new ArrayList<>());
            hm.get(n1).add(n2);
            hm.get(n2).add(n1);
        }

        int numParts = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, hm, visited);
                numParts++;
            }
        }

        return numParts;
    }

    private void dfs(int node, HashMap<Integer, ArrayList<Integer>> hm, HashSet<Integer> visited) {
        visited.add(node);

        if (hm.containsKey(node)) {
            ArrayList<Integer> list = hm.get(node);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int newN = list.get(i);
                if (!visited.contains(newN)) dfs(newN, hm, visited);
            }
        }
    }
}
