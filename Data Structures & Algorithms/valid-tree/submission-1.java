class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (!hm.containsKey(n1)) {
                hm.put(n1, new ArrayList<>());
            }
            if (!hm.containsKey(n2)) {
                hm.put(n2, new ArrayList<>());
            }
            hm.get(n1).add(n2);
            hm.get(n2).add(n1);
        }
       
        HashSet<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, hm, visited)) {
            return false;
        }

        return visited.size() == n;
    }
    private boolean dfs(int nod, int prev, HashMap<Integer, ArrayList<Integer>> hm, HashSet<Integer> visited) {
        if (visited.contains(nod)) return false;
        
        visited.add(nod);

        if (hm.containsKey(nod)) {
            ArrayList<Integer> arr = hm.get(nod);
            int size = arr.size();

            for (int i = 0; i < size; i++) {
                if (arr.get(i)==prev) continue;
                if (!dfs(arr.get(i), nod, hm, visited)) return false;
            }
        }

        return true;
    }
}
