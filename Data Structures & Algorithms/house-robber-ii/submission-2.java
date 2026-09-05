class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        int res1 = dp(0, nums.length - 2, nums, memo1);
        int res2 = dp(1, nums.length - 1, nums, memo2);

        return Math.max(res1, res2);
    } 
    private int dp(int i, int end, int[] nums, int[] memo) {
        if (i>end) return 0;
        if (memo[i]!=-1) return memo[i];

        int rob_curr = nums[i] + dp(i+2, end, nums, memo);
        int skip_curr = dp(i+1, end, nums, memo);

        memo[i] = Math.max(rob_curr, skip_curr);

        return memo[i];
    }
}
