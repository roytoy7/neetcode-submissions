class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];

            if (!hm.containsKey(u)) {
                hm.put(u, new ArrayList<>());
            }
            hm.get(u).add(new int[]{v, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, k});
        HashSet<Integer> visited = new HashSet<>();
        int time = 0;
        while (!pq.isEmpty()) {
            int u = pq.peek()[1];
            int t = pq.poll()[0];

            if (!visited.contains(u)) {
                visited.add(u);
                time = Math.max(t, time);
                if (!hm.containsKey(u)) continue;
                for (int[] neighbor : hm.get(u)) {
                    int node = neighbor[0];
                    if (!visited.contains(node)) pq.offer(new int[]{time + neighbor[1], node});
                }
            }
            
        }
        return visited.size() == n ? time : -1;
    }
}
