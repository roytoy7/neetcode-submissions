class Solution {
    public int minCostConnectPoints(int[][] points) {
        int minCost = 0;
        HashSet<Integer> visited = new HashSet<>();
    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()) {
            int point = pq.peek()[1];
            int cost = pq.poll()[0];

            if (visited.contains(point)) continue;

            visited.add(point);
            minCost += cost; 

            for (int i = 1; i < points.length; i++) {
                if (!visited.contains(i)) pq.offer(new int[]{manDist(points[point], points[i]), i});
            }
        }

        return minCost;
    }
    private int manDist(int[] p1, int[] p2) {
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
}
