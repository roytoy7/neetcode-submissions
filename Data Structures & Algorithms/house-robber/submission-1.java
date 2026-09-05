class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 0);
        return dp(0, memo, nums);
    }
    private int dp(int i, int[] memo, int[] nums) {
        if (i>=nums.length) return 0;
        if (memo[i]!=0) return memo[i];

        int rob_cur = nums[i] + dp(i+2, memo, nums);
        int skip_cur = dp(i+1, memo, nums);

        memo[i] = Math.max(rob_cur, skip_cur);
        
        return memo[i];
    }
}
