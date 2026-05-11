class Solution {
    public int maxProfit(int[] prices) {
        int p = prices.length;
        if (p<2) return 0;
        int min = prices[0];
        
        int maxProf = 0;
        for (int i = 1; i < p;i++){
            maxProf = Math.max(maxProf, prices[i]-min);
            min = Math.min(prices[i], min);
        }
        
        return maxProf;
    }
}
