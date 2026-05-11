class Solution {
    public int maxProfit(int[] prices) {
        int p = prices.length;
        if (p<2) return 0;
        int[] minArr = new int[p];
        minArr[0] = prices[0];
        int maxProf = 0;
        for (int i = 1; i < p;i++){
            minArr[i] = Math.min(prices[i], minArr[i-1]);
            maxProf = Math.max(maxProf, prices[i]-minArr[i]);
        }
        
        return maxProf;
    }
}
