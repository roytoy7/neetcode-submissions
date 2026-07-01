class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) pq.offer(stones[i]);
        while (pq.size()>1) {
            int f = pq.poll();
            int s = pq.poll();
            if (f!=s) {
                pq.offer(Math.abs(f-s));
            }
        }
        if (pq.isEmpty()) return 0;
        return pq.poll();
    }
}
