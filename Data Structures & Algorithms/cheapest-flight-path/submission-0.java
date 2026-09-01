class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k+1; i++) {
            int[] temp = Arrays.copyOf(prices, n);

            for (int[] flight: flights) {
                int sour = flight[0];
                int dest = flight[1];
                int prc = flight[2];

                if (prices[sour]==Integer.MAX_VALUE) continue;
                else if (prices[sour] + prc < temp[dest]) temp[dest] = prices[sour] + prc;
            }
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
