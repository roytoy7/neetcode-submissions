class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] closest = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(dist(p2[0], p2[1]), dist(p1[0], p1[1]));
        });
        for (int i = 0; i < points.length; i++) {
            if (pq.size()<k) pq.offer(new int[] {points[i][0], points[i][1]});
            else if (dist(pq.peek()[0], pq.peek()[1]) > dist(points[i][0], points[i][1])) {
                pq.poll();
                pq.offer(new int[] {points[i][0], points[i][1]});
            }
        }
        for (int i = 0; i < k; i++) {
            int[] a = pq.poll();
            closest[i] = new int[] {a[0], a[1]};
        }
        return closest;
    }
    public int dist(int x, int y) {
        return x*x + y*y;
    }
}
